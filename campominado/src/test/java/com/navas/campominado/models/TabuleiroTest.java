package com.navas.campominado.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class GerarCamposTest {

    private Tabuleiro tabuleiro;

    private int linhas;
    private int colunas;

    @BeforeEach
    void setup() {
        linhas = 10;
        colunas = 10;
        tabuleiro = new Tabuleiro(linhas, colunas, 20);
    }

    @Test
    void verificarTamanhoTabuleiro() {
        Campo[][] campos = tabuleiro.getCampos();
        assertEquals(campos.length, linhas);
        assertEquals(campos[0].length, colunas);
    }


    @Test
    void verificarNaoNullCamposDoTabuleiro() {
        Campo[][] campos = tabuleiro.getCampos();
        IntStream.range(0, linhas).forEach(linha -> {
            IntStream.range(0, colunas).forEach(coluna -> {
                assertNotNull(campos[linha][coluna]);
            });
        });
    }
}

class AssociarOsVizinhosTest {

    private Tabuleiro tabuleiro;

    private int linhas;
    private int colunas;

    @BeforeEach
    void setup() {
        linhas = 10;
        colunas = 10;
        tabuleiro = new Tabuleiro(linhas, colunas, 20);
    }

    @Test
    void verificarQuantidadeVizinho() {
        int minimoDeVizinho = 3;
        int maximoDeVizinho = 8;

        Campo[][] campos = tabuleiro.getCampos();
        IntStream.range(0, linhas).forEach(linha ->
                IntStream.range(0, colunas).forEach(coluna -> {
                    int quantidadeVizinhos = campos[linha][coluna].getVizinhos().size();
                    boolean quantidadeCorretaVizinhos =
                            quantidadeVizinhos >= minimoDeVizinho
                                    && quantidadeVizinhos <= maximoDeVizinho;
                    assertTrue(quantidadeCorretaVizinhos);
                }));
    }
}
