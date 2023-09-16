package com.navas.campominado.models;

import com.navas.campominado.exceptions.ExplosaoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CampoTest {

    private Campo campo;


    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);
    }


    @Test
    void testeVizinhoReal() {
        Map<Campo, Boolean> casosTeste = new HashMap<>() {{
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

        for (Map.Entry<Campo, Boolean> casoTeste : casosTeste.entrySet()) {
            boolean adicionado = campo.adicionarVizinho(casoTeste.getKey());
            assertEquals(adicionado, casoTeste.getValue(), String.format("campo x=%d, y=%d", casoTeste.getKey().getLinha(), casoTeste.getKey().getColuna()));
        }
    }

    @Test
    void testeAlterarMarcacao() {
        assertFalse(campo.isMarcado(), "marcado deveria ser false");
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado(), "marcado deveria ser true");
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado(), "marcado deveria ser false");
    }

    @Test
    void testeVizinhacaSegura() {
        Campo[] vizinhos = {
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
        boolean vizinhacaSegura = campo.vizinhacaSegura();
        assertTrue(vizinhacaSegura,
                "a vizinhaca deveria ser segura, pois nenhum dos vizinhos está minado");

    }

    @Test
    void testeVizinhacaInsegura() {
        Campo[] vizinhos = {
                new Campo(3, 2, true),
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
        boolean vizinhacaSegura = campo.vizinhacaSegura();
        assertFalse(vizinhacaSegura,
                "a vizinhaca não deveria ser segura, pois o " +
                        "primeiro vizinho da lista está minado");

    }

    @Test
    void testeAbrirMarcado() {
        Campo[] vizinhos = {
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
        campo.alternarMarcacao();
        boolean aberto = campo.abrir();
        assertFalse(aberto);
    }

    @Test
    void testeAbrirMinado() {
        campo = new Campo(campo.getLinha(), campo.getColuna(), true);
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
    void testeAbrir() {
        boolean aberto = campo.abrir();
        assertTrue(aberto);
    }
}
