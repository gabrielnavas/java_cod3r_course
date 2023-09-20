package com.navas.campominado.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Tabuleiro {

    // TODO: implementar usando matrix => List<List<Campo>> campos = new ArrayList<>();
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
            // TODO: implementar lançamento de exception ou tratar isso
        }

        try {
            campos.parallelStream()
                    .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                    .findFirst()
                    .ifPresent(Campo::abrir);
        } catch (Exception e) {
            // FIXME: ajustar a implementação do método do abrir
            campos.forEach(c -> c.setAberto(true));
            throw e;
        }
    }

    public void alterarMarcacaoCampo(int linha, int coluna) {
        if (linha >= linhas || coluna >= colunas || linha < 0 || coluna < 0) {
            // TODO: implementar lançamento de exception ou tratar isso
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
}
