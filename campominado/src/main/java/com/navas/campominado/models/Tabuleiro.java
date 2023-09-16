package com.navas.campominado.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

public class Tabuleiro {

    // TODO: imnplementar usando matrix => List<List<Campo>> campos = new ArrayList<>();
    private final List<Campo> campos = new ArrayList<>();
    private int linhas;
    private int colunas;
    private int minas;

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;

        gerarCampos();
        associarOsVizinhos();
        sortearMinas();
    }

    private void gerarCampos() {
        IntStream.range(0, linhas).forEach(linha ->
                IntStream.range(0, colunas).forEach(coluna -> {
                    Campo campo = new Campo(linha, coluna);
                    campos.add(campo);
                }));
    }

    private void associarOsVizinhos() {
        campos.forEach(campoA -> campos.forEach(campoA::adicionarVizinho));
    }

    private void sortearMinas() {
        int minasArmadas = 0;

        do {
            int linha = new Random().nextInt(linhas);
            int coluna = new Random().nextInt(colunas);

            Optional<Campo> campoOptional = campos
                    .stream()
                    .filter(campoN -> campoN.getLinha() == linha
                            && campoN.getColuna() == coluna
                    ).findFirst();

            if (campoOptional.isPresent()) {
                Campo campo = campoOptional.get();
                if (!campo.isMinado()) {
                    campo.minar();
                    minasArmadas++;
                }
            }
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
}
