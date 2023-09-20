package com.navas.campominado.views;

import com.navas.campominado.models.Tabuleiro;

public class TesteObservadorTabuleiro {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(1, 1, 1);
        tabuleiro.registrarObservador(resultado -> {
            if (resultado.isGanhou()) {
                System.out.println("você ganhou!!");
            } else {
                System.out.println("você perdeu!!");
            }
        });
        tabuleiro.alterarMarcacaoCampo(0, 0);
    }
}
