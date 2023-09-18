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
        try {
            for (Campo campo : campos) {
                if (campo.getLinha() == linha
                        && campo.getColuna() == coluna) {
                    campo.abrir();
                    return;
                }
            }
            throw new CampoNaoEncontradoException(linha, coluna);
        } catch (ExplosaoException ex) {
            campos.forEach(campo -> campo.setAberto(true));
            throw ex;
        }
    }

    public void alterarMarcacaoCampo(int linha, int coluna) {
        for (Campo campo : campos) {
            if (campo.getLinha() == linha
                    && campo.getColuna() == coluna) {
                campo.alternarMarcacao();
                return;
            }
        }
        throw new CampoNaoEncontradoException(linha, coluna);
    }

    private void gerarCampos() {
        IntStream.range(0, linhas).forEach(linha ->
                IntStream.range(0, colunas).forEach(coluna -> {
                    Campo campo = new Campo(linha, coluna);
                    campos.add(campo);
                }));
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
        StringBuilder tabuleiroStr = new StringBuilder();

        tabuleiroStr.append("  ");
        for (int i = 0; i < colunas; i++) {
            tabuleiroStr.append(String.format("%d ", i + 1));
        }
        tabuleiroStr.append("\n");

        for (int i = 0; i < linhas; i++) {
            tabuleiroStr.append(String.format("%d ", i + 1));
            for (int j = 0; j < colunas; j++) {
                String campoStr = campos.get(i + j).toString();
                tabuleiroStr.append(campoStr);
                tabuleiroStr.append(" ");
            }
            tabuleiroStr.append("\n");
        }
        return tabuleiroStr.toString();
    }
}
