package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Observador {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Observador");

        // operacção de fechar a janela
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // tamanho da janela
        janela.setSize(600,200);

        // adicionar um layout, ver os componentes de uma forma mais interessante
        janela.setLayout(new FlowLayout());

        // centralizar na tela do pc
        janela.setLocationRelativeTo(null);

        // definir um botão
        JButton botao = new JButton("Click em mim!!");

        // definir o tamanho do botão
        botao.setSize(400, 200);

        // esse método usa uma interface funcional
        botao.addActionListener(e -> {
            System.out.println("fui chamado");
        });

        // esse método é preciso implementar uma classe, já que existem dois métodos a serem implementados
        botao.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                System.out.println("botão ganhou o foco!");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                System.out.println("botão perdeu o foco!");
            }
        });

        // mostrar a janela
        janela.setVisible(true);

        // adicionar o botão na janela
        janela.add(botao);
    }
}
