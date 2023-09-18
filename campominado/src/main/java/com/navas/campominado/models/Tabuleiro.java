package com.navas.campominado.models;

import com.navas.campominado.exceptions.CampoNaoEncontradoException;
import com.navas.campominado.exceptions.ExplosaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Tabuleiro {

    // TODO: imnplementar usando matrix => List<List<Campo>> campos = new ArrayList<>();
    private final List<Campo> campos;
    private int linhas;
    private int colunas;
    private int minas;

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;
        this.campos = new ArrayList<>();

        gerarCampos();
        associarOsVizinhos();
        sortearMinas();
    }

    public void abrirCampo(int linha, int coluna) {
        if (linha >= linhas || coluna >= colunas || linha < 0 || coluna < 0) {
            throw new CampoNaoEncontradoException(linha, coluna);
        }
        
        try {
            campos.parallelStream()
                    .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                    .findFirst()
                    .ifPresent(Campo::abrir);
        } catch (ExplosaoException e) {
            campos.forEach(c -> c.setAberto(true));
            throw e;
        }
    }

    public void alterarMarcacaoCampo(int linha, int coluna) {
        if (linha >= linhas || coluna >= colunas || linha < 0 || coluna < 0) {
            throw new CampoNaoEncontradoException(linha, coluna);
        }
        campos.parallelStream()
                .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                .findFirst()
                .ifPresent(Campo::alternarMarcacao);
    }

    private void gerarCampos() {
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                campos.add(new Campo(linha, coluna));
            }
        }
    }

    private void associarOsVizinhos() {
        for (Campo c1 : campos) {
            for (Campo c2 : campos) {
                c1.adicionarVizinho(c2);
            }
        }
    }

    private void sortearMinas() {
        long minasArmadas = 0;
        Predicate<Campo> minado = Campo::isMinado;

        do {
            int aleatorio = (int) (Math.random() * campos.size());
            campos.get(aleatorio).minar();
            minasArmadas = campos.stream().filter(minado).count();
        } while (minasArmadas < minas);
    }

    public Campo[][] getCampos() {
        Campo[][] campos = new Campo[linhas][colunas];
        IntStream.range(0, linhas).forEach(linha ->
                IntStream.range(0, colunas).forEach(coluna -> {
                    Optional<Campo> campo = this.campos
                            .stream()
                            .filter(campoN -> campoN.getLinha() == linha
                                    && campoN.getColuna() == coluna
                            ).findFirst();
                    campo.ifPresent(value -> campos[linha][coluna] = value);
                }));
        return campos;
    }

    public boolean objetivoAlcando() {
        return campos.stream().allMatch(Campo::objetivoAlcancado);
    }

    public void reiniciar() {
        campos.forEach(Campo::reiniciar);
        sortearMinas();
    }

    public int getColunas() {
        return colunas;
    }

    public int getLinhas() {
        return linhas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("  ");
        for (int c = 0; c < colunas; c++) {
            sb.append(" ");
            sb.append(c);
            sb.append(" ");
        }

        sb.append("\n");

        int i = 0;
        for (int l = 0; l < linhas; l++) {
            sb.append(l);
            sb.append(" ");
            for (int c = 0; c < colunas; c++) {
                sb.append(" ");
                sb.append(campos.get(i));
                sb.append(" ");
                i++;
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
