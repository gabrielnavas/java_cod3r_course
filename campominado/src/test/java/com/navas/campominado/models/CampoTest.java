package com.navas.campominado.models;

import com.navas.campominado.exceptions.ExplosaoException;
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
        assertThrows(ExplosaoException.class, () -> {
            boolean aberto = campo.abrir();
            assertFalse(aberto);
        });
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
}
