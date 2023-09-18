package com.navas.campominado.views;

import com.navas.campominado.exceptions.ExplosaoException;
import com.navas.campominado.exceptions.SairException;
import com.navas.campominado.models.Tabuleiro;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TabuleiroConsole {

    private final Tabuleiro tabuleiro;
    private final Scanner entrada;

    public TabuleiroConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.entrada = new Scanner(System.in);

        executarJogo();
    }

    private void executarJogo() {
        try {
            boolean continuar = true;

            while (continuar) {
                cicloDoJogo();

                String resposta = capturarValorDigitado("Outra partida? (S/n) ");

                if ("n".equalsIgnoreCase(resposta)) {
                    continuar = false;
                } else {
                    tabuleiro.reiniciar();
                }
            }
        } catch (SairException ex) {
            System.out.println("Tchau!!");
        } finally {
            entrada.close();
        }
    }

    private void cicloDoJogo() {
        try {
            while (!tabuleiro.objetivoAlcando()) {
                System.out.println(tabuleiro);

                String digitado = capturarValorDigitado("Digite (x, y): ");

                try {
                    List<Integer> coodernadas = Arrays.stream(
                                    digitado.replaceAll(" ", "").split(",")
                            )
                            .map(Integer::parseInt)
                            .toList();

                    if (coodernadas.size() != 2 && (coodernadas.get(0) >= tabuleiro.getLinhas() || coodernadas.get(1) >= tabuleiro.getColunas())) {
                        System.out.println("Digite o x e y corretamente.");
                        continue;
                    }

                    String acao = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar: ");

                    if ("1".equalsIgnoreCase(acao)) {
                        tabuleiro.abrirCampo(coodernadas.get(0) - 1, coodernadas.get(1) - 1);
                    } else if ("2".equalsIgnoreCase(acao)) {

                    }


                } catch (NumberFormatException ex) {
                    System.out.println("Digite apenas coodernadas.");
                }

            }

            System.out.println("Você ganhou!!!");
        } catch (ExplosaoException ex) {
            System.out.println(tabuleiro);
            System.out.println("Você perdeu!");
        }
    }

    private String capturarValorDigitado(String texto) {
        System.out.println("\nDigite 'sair' para terminar o jogo.");
        System.out.print(texto);
        String digitado = entrada.nextLine();

        if ("sair".equalsIgnoreCase(digitado)) {
            throw new SairException();
        }

        return digitado;
    }
}
