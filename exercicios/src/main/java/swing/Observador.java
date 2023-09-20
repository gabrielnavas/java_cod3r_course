package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("um evento aconteceu");
            }
        });

        // mostrar a janela
        janela.setVisible(true);

        // adicionar o botão na janela
        janela.add(botao);
    }
}
