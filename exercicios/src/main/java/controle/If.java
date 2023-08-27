package controle;

import java.util.Scanner;

public class If {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe a média: ");
        double media = entrada.nextDouble();

        boolean aprovado = media >= 7 && media <= 10;
        if (aprovado) {
            System.out.println("Aprovado!");
            System.out.println("Parabéns");
        }

        boolean recuperacao = media >= 4.5 && media < 7;
        if (recuperacao) {
            System.out.println("Recuperacao");
        }

        boolean reprovado = media >= 0 && media < 4.5;
        if (reprovado) {
            System.out.println("Reprovado");
        }

        entrada.close();
    }
}
