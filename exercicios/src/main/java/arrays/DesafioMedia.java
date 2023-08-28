package arrays;

import java.util.Scanner;

public class DesafioMedia {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int quantidadeNotas = quantidadeNotas(entrada);
        double[] notas = pegarNotas(entrada, quantidadeNotas);
        double media = calcularMedia(notas);

        System.out.printf("Média é: %.2f\n", media);

        entrada.close();
    }

    static int quantidadeNotas(Scanner entrada) {
        System.out.print("Digite a quantidade de notas: ");
        return entrada.nextInt();
    }

    static double[] pegarNotas(Scanner entrada, int quantidadeNotas) {
        double[] notas = new double[quantidadeNotas];
        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.printf("Entre com a %dª nota: ", i + 1);
            notas[i] = entrada.nextDouble();
        }
        return notas;
    }

    static double calcularMedia(double[] notas) {
        double somatoria = 0.0;
        for (double nota : notas) {
            somatoria += nota;
        }

        return somatoria / notas.length;
    }
}
