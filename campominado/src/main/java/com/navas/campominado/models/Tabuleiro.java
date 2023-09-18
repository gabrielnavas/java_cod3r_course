package com.navas.campominado.models;

import com.navas.campominado.exceptions.CampoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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
        campos.stream()
                .filter(campo ->
                        campo.getLinha() == linha
                                && campo.getColuna() == coluna
                )
                .findFirst()
                .ifPresentOrElse(Campo::abrir, () -> {
                    throw new CampoNaoEncontradoException(linha, coluna);
                });
    }

    public void alterarMarcacaoCampo(int linha, int coluna) {
        campos.stream()
                .filter(campo ->
                        campo.getLinha() == linha
                                && campo.getColuna() == coluna
                )
                .findFirst()
                .ifPresentOrElse(Campo::alternarMarcacao, () -> {
                    throw new CampoNaoEncontradoException(linha, coluna);
                });
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

    public boolean objetivoAlcando() {
        return campos.stream().allMatch(Campo::objetivoAlcancado);
    }

    public void reiniciar() {
        campos.forEach(Campo::reiniciar);
        sortearMinas();
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
