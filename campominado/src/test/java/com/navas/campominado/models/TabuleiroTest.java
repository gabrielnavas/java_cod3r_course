package com.navas.campominado.models;

import com.navas.campominado.exceptions.CampoNaoEncontradoException;
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
        IntStream.range(0, linhas).forEach(linha ->
                IntStream.range(0, colunas).forEach(coluna -> {
                    assertNotNull(campos[linha][coluna]);
                }));
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

class SortearMinasTest {

    private Tabuleiro tabuleiro;

    private int linhas;
    private int colunas;

    private int minados;

    @BeforeEach
    void setup() {
        linhas = 10;
        colunas = 10;
        minados = 20;
        tabuleiro = new Tabuleiro(linhas, colunas, minados);
    }

    @Test
    void quantidadeDeMinas() {
        Campo[][] campos = tabuleiro.getCampos();

        int quantidadeMinados = 0;

        for (int i = 0; i < campos.length; i++) {
            for (int j = 0; j < campos[0].length; j++) {
                if (campos[i][j].isMinado()) {
                    quantidadeMinados++;
                }
            }
        }

        assertEquals(minados, quantidadeMinados);
    }
}

class ObjetivoAlcandoTabuleiroTest {
    private Tabuleiro tabuleiro;

    @BeforeEach
    void setup() {
        int linhas = 10;
        int colunas = 10;
        int minados = 20;
        tabuleiro = new Tabuleiro(linhas, colunas, minados);
    }

    @Test
    public void objetivoNaoAlcando() {
        assertFalse(tabuleiro.objetivoAlcando());
    }

    @Test
    public void objetivoAlcando() {
        // TODO: fazer...
    }
}


class ReiniciarTabuleiroTest {
    private Tabuleiro tabuleiro;

    @BeforeEach
    void setup() {
        int linhas = 10;
        int colunas = 10;
        int minados = 20;
        tabuleiro = new Tabuleiro(linhas, colunas, minados);
    }

    @Test
    public void reiniciar() {
        // TODO: abrir algum campo antes. Ainda não tem método pra isso.

        assertDoesNotThrow(() -> {
            tabuleiro.reiniciar();
        });
    }
}


class ToStringTabuleiroTest {
    private Tabuleiro tabuleiro;

    @BeforeEach
    void setup() {
        int linhas = 10;
        int colunas = 10;
        int minados = 20;
        tabuleiro = new Tabuleiro(linhas, colunas, minados);
    }

    @Test
    public void tamanhoTabuleiro() {
        String tabuleiroPrint = tabuleiro.toString();
        String[] linhasTabuleiro = tabuleiroPrint.split("\n");
        String[] primeiraColuna = linhasTabuleiro[0].split(" ");
        assertEquals(11, linhasTabuleiro.length);
        assertEquals(22, primeiraColuna.length);
    }
}


class AbrirCampoTabuleiroTest {
    int linhas = 10;
    int colunas = 10;
    private Tabuleiro tabuleiro;


    @BeforeEach
    void setup() {

        int minados = 20;
        tabuleiro = new Tabuleiro(linhas, colunas, minados);
    }


    @Test()
    public void verificarAberturaDoCampo() throws Exception {
        int linha = 5;
        int coluna = 6;

        try {
            tabuleiro.abrirCampo(linha, coluna);

            Campo[][] campos = tabuleiro.getCampos();
            assertTrue(campos[linha][coluna].isAberto());
        } catch (Exception ex) {

        }
    }


    @Test
    public void abrirCampoNaoExistente() {
        assertThrows(
                CampoNaoEncontradoException.class,
                () -> tabuleiro.abrirCampo(linhas, colunas)
        );
        assertThrows(
                CampoNaoEncontradoException.class,
                () -> tabuleiro.abrirCampo(-1, -1)
        );
    }
}


class MarcarCampoTabuleiroTest {
    int linhas = 10;
    int colunas = 10;
    private Tabuleiro tabuleiro;

    @BeforeEach
    void setup() {
        int minados = 20;
        tabuleiro = new Tabuleiro(linhas, colunas, minados);
    }

    @Test
    public void verificarAlterarMarcacaoCampoDoCampo() {
        int linha = 5;
        int coluna = 6;

        assertDoesNotThrow(() -> tabuleiro.alterarMarcacaoCampo(linha, coluna));

        Campo[][] campos = tabuleiro.getCampos();
        assertTrue(campos[linha][coluna].isMarcado());
    }


    @Test
    public void alterarMarcacaoCampoNaoExistente() {
        assertThrows(
                CampoNaoEncontradoException.class,
                () -> tabuleiro.alterarMarcacaoCampo(linhas, colunas)
        );
        assertThrows(
                CampoNaoEncontradoException.class,
                () -> tabuleiro.alterarMarcacaoCampo(-1, -1)
        );
    }
}



