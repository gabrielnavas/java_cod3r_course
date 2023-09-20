package com.navas.campominado.views;

import com.navas.campominado.models.Tabuleiro;

import javax.swing.*;
import java.awt.*;

public class PainelTabuleiro extends JPanel {

    public PainelTabuleiro(Tabuleiro tabuleiro) {
        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
        tabuleiro.paraCadaCampo(campo -> add(new BotaoCampo(campo)));

        tabuleiro.registrarObservador(e -> {
            
        });
    }
}
