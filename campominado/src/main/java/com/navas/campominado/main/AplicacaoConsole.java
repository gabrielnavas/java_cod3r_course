package com.navas.campominado.main;

import com.navas.campominado.models.Tabuleiro;
import com.navas.campominado.views.TabuleiroConsole;

public class AplicacaoConsole {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
        TabuleiroConsole tabuleiroConsole = new TabuleiroConsole(tabuleiro);
    }
}
