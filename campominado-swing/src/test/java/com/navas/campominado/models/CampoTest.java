package com.navas.campominado.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AdicionarVizinhoTest {
    Map<Campo, Boolean> casosTeste;
    private Campo campo;

    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);
        casosTeste = new HashMap<>() {{
            put(new Campo(3, 2), true);
            put(new Campo(3, 4), true);
            put(new Campo(2, 3), true);
            put(new Campo(4, 3), true);

            put(new Campo(4, 4), true);
            put(new Campo(2, 2), true);
            put(new Campo(2, 4), true);
            put(new Campo(4, 2), true);

            put(new Campo(3, 1), false);
            put(new Campo(3, 5), false);
            put(new Campo(1, 3), false);
            put(new Campo(5, 3), false);

            put(new Campo(5, 5), false);
            put(new Campo(1, 1), false);
            put(new Campo(1, 5), false);
            put(new Campo(5, 1), false);
        }};
    }

    @Test
    void testeVizinhoReal() {
        for (Map.Entry<Campo, Boolean> casoTeste : casosTeste.entrySet()) {
            boolean adicionado = campo.adicionarVizinho(casoTeste.getKey());
            String messageAssert = String.format("campo x=%d, y=%d",
                    casoTeste.getKey().getLinha(), casoTeste.getKey().getColuna());
            assertEquals(adicionado, casoTeste.getValue(), messageAssert);
        }
    }
}

class VizinhacaSeguraTest {
    private Campo campo;
    private Campo[] vizinhos;

    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);
        vizinhos = new Campo[]{
                new Campo(3, 2),
                new Campo(3, 4),
                new Campo(2, 3),
                new Campo(4, 3),
                new Campo(4, 4),
                new Campo(2, 2),
                new Campo(2, 4),
                new Campo(4, 2)
        };
        Arrays.stream(vizinhos)
                .forEach(campo::adicionarVizinho);
    }

    @Test
    void testeVizinhacaSegura() {
        boolean vizinhacaSegura = campo.vizinhacaSegura();
        String messageAssert = "a vizinhaca deveria ser segura, pois nenhum dos vizinhos está minado";
        assertTrue(vizinhacaSegura, messageAssert);

    }

    @Test
    void testeVizinhacaInsegura() {
        vizinhos[0].minar();
        boolean vizinhacaSegura = campo.vizinhacaSegura();
        assertFalse(vizinhacaSegura,
                "a vizinhaca não deveria ser segura, pois o " +
                        "primeiro vizinho da lista está minado");

    }
}

class AlterarMarcacaoTest {
    private Campo campo;


    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);
    }

    @Test
    void testeAlterarMarcacao() {
        assertFalse(campo.isMarcado(), "marcado deveria ser false");
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado(), "marcado deveria ser true");
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado(), "marcado deveria ser false");
    }
}

class MinarTest {

    private Campo campo;

    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);
    }

    @Test
    void testeMinar() {
        campo.minar();
        assertTrue(campo.isMinado());
    }
}

class AbrirTest {

    private Campo campo;


    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);
    }

    @Test
    void testeAbrirMinado() {
        campo = new Campo(campo.getLinha(), campo.getColuna());
        campo.minar();
        boolean aberto = campo.abrir();
        assertTrue(aberto);
    }

    @Test
    void testeAbrirMarcadoAberto() {
        campo.alternarMarcacao();
        boolean aberto = campo.abrir();
        assertFalse(aberto);
    }

    @Test
    void testeAbrirAberto() {
        campo.abrir();
        boolean aberto = campo.abrir();
        assertFalse(aberto);
    }

    @Test
    void testeAbrirMarcado() {
        campo.alternarMarcacao();
        boolean aberto = campo.abrir();
        assertFalse(aberto);
    }

    @Test
    void testeAbrir() {
        boolean aberto = campo.abrir();
        assertTrue(aberto);
    }
}


class AbrirComVizinhoTest {
    private Campo campo;
    private Campo[] vizinhos;


    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);
        vizinhos = new Campo[]{
                new Campo(3, 2),
                new Campo(3, 4),
                new Campo(2, 3),
                new Campo(4, 3),
                new Campo(4, 4),
                new Campo(2, 2),
                new Campo(2, 4),
                new Campo(4, 2)
        };
        Arrays.stream(vizinhos)
                .forEach(campo::adicionarVizinho);
    }

    @Test
    void testeAbrirVizinhos() {
        campo.abrir();
        Arrays.stream(vizinhos).forEach(vizinho -> assertTrue(vizinho.isAberto()));
    }

    @Test
    void testeNaoAbrirVizinhos() {
        vizinhos[0].minar();
        campo.abrir();
        Arrays.stream(vizinhos).forEach(vizinho -> assertFalse(vizinho.isAberto()));
    }

    @Test
    void testeAbrir() {
        boolean aberto = campo.abrir();
        assertTrue(aberto);
    }
}


class NaoAbrirVizinhoDoVizinhoTest {
    private Campo campo;
    private Campo[] vizinhacaDoPrimeiro;
    private Campo[] vizinhacaDoSegundo;


    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);

        Campo[] vizinhaca = new Campo[]{
                new Campo(3, 2),
                new Campo(3, 4),
                new Campo(2, 3),
                new Campo(4, 3),
                new Campo(4, 4),
                new Campo(2, 2),
                new Campo(2, 4),
                new Campo(4, 2)
        };

        vizinhacaDoPrimeiro = new Campo[]{
                new Campo(3, 2),
                new Campo(3, 4),
        };

        vizinhacaDoSegundo = new Campo[]{
                new Campo(3, 2),
                new Campo(3, 4),
        };

        Arrays.stream(vizinhaca)
                .forEach(campo::adicionarVizinho);

        Arrays.stream(vizinhacaDoPrimeiro)
                .forEach(vizinhaca[0]::adicionarVizinho);

        Arrays.stream(vizinhacaDoSegundo)
                .forEach(vizinhaca[1]::adicionarVizinho);
    }

    @Test
    void testeAbrirVizinhosDoPrimeiro() {
        vizinhacaDoPrimeiro[0].minar();
        campo.abrir();
        campo.getVizinhos().forEach(vizinho -> assertTrue(vizinho.isAberto()));
        campo.getVizinhos().get(0)
                .getVizinhos()
                .forEach(vizinho -> assertFalse(vizinho.isAberto()));
    }

    @Test
    void testeAbrirVizinhosDoSegundo() {
        vizinhacaDoSegundo[0].minar();
        campo.abrir();
        campo.getVizinhos().forEach(vizinho -> assertTrue(vizinho.isAberto()));
        campo.getVizinhos().get(1)
                .getVizinhos()
                .forEach(vizinho -> assertFalse(vizinho.isAberto()));
    }
}

class ObjetivoAlcandoTest {
    private Campo campo;

    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);
    }

    @Test
    void testeObjetivoNaoAlcando() {
        assertFalse(campo.objetivoAlcancado());
    }

    @Test
    void testeObjetivoNaoAlcandoMinado() {
        boolean minado = campo.isMinado();
        assertFalse(minado && campo.objetivoAlcancado());
    }

    @Test
    void testeObjetivolcandoAberto() {
        boolean aberto = campo.abrir();
        assertTrue(aberto && campo.objetivoAlcancado());
    }


    @Test
    void testeObjetivoAlcandoMinadoMarcado() {
        campo.minar();
        campo.alternarMarcacao();
        assertTrue(campo.objetivoAlcancado());
    }
}

class MinasnaVizinhacaTest {
    private Campo campo;
    private Campo vizinho;

    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);
        vizinho = new Campo(3, 2);
        campo.adicionarVizinho(vizinho);
    }

    @Test
    void testeUmaMinaNaVizinhaca() {
        vizinho.minar();
        assertEquals(campo.minasNaVizinhaca(), 1);
    }


    @Test
    void testenenhumaMinaNaVizinhaca() {
        assertEquals(campo.minasNaVizinhaca(), 0);
    }
}

class ReiniciarTest {
    private Campo campo;

    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);
    }

    @Test
    void testeReiniciarDepoisDeMinar() {
        campo.minar();
        campo.reiniciar();
        boolean reiniciado = !campo.isMinado() && !campo.isAberto() && !campo.isMarcado();
        assertTrue(reiniciado);
    }

    @Test
    void testeReiniciarDepoisDeAbrir() {
        campo.abrir();
        campo.reiniciar();
        boolean reiniciado = !campo.isMinado() && !campo.isAberto() && !campo.isMarcado();
        assertTrue(reiniciado);
    }

    @Test
    void testeReiniciarDepoisDeMarcar() {
        campo.alternarMarcacao();
        campo.reiniciar();
        boolean reiniciado = !campo.isMinado() && !campo.isAberto() && !campo.isMarcado();
        assertTrue(reiniciado);
    }
}
