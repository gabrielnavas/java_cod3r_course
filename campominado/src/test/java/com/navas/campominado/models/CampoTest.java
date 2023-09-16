package com.navas.campominado.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CampoTest {

    private Campo campo;


    @BeforeEach
    void setup() {
        campo = new Campo(3, 3);
    }


    @Test
    void testeVizinhoReal() {
        Map<Campo, Boolean> casosTeste = new HashMap<>(){{
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

        for (Map.Entry<Campo, Boolean> casoTeste: casosTeste.entrySet()) {
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
}
