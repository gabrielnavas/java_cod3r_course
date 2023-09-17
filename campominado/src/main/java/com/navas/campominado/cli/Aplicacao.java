package com.navas.campominado.cli;

import com.navas.campominado.models.Tabuleiro;

public class Aplicacao {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
        System.out.println(tabuleiro);
    }
}
