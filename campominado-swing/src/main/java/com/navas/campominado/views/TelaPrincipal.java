package com.navas.campominado.views;

import com.navas.campominado.models.Tabuleiro;

import javax.swing.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal() {
        Tabuleiro tabuleiro = new Tabuleiro(16, 30, 50);

        PainelTabuleiro painelTabuleiro = new PainelTabuleiro(tabuleiro);
        add(painelTabuleiro);

        setTitle("Campo Minado");
        setSize(690, 438);
        setLocationRelativeTo(null); // centralizar na tela, quando abrir em janela.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // operação de fechar
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
