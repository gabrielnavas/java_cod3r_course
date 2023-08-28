package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrizMedia {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Quantidade de alunos: ");
        int quantidadeAlunos = entrada.nextInt();

        System.out.print("Quantidade de notas por alunos: ");
        int quantidaNotas = entrada.nextInt();

        // pega nota de cada aluno
        double[][] notasTurma = new double[quantidadeAlunos][quantidaNotas];
        for (int i = 0; i < quantidadeAlunos; i++) {
            for (int j = 0; j < quantidaNotas; j++) {
                System.out.printf("%dª nota do %dª aluno: ", j + 1, i + 1);
                notasTurma[i][j] = entrada.nextDouble();
            }
        }

        // calcula media por aluno
        double[] mediaAlunos = new double[quantidadeAlunos];
        for (int i = 0; i < quantidadeAlunos; i++) {
            double soma = 0.0;
            for (int j = 0; j < quantidaNotas; j++) {
                soma += notasTurma[i][j];
            }
            mediaAlunos[i] = soma / quantidaNotas;
        }

        // mostra media de cada aluno
        System.out.println(Arrays.toString(mediaAlunos));

        // calcula media da turma toda
        double somaMediaTurma = 0.0;
        for (int i = 0; i < mediaAlunos.length; i++) {
            somaMediaTurma +=             mediaAlunos[i];
        }
        double mediaTurma = somaMediaTurma / mediaAlunos.length;

        // mostra media da turma toda
        System.out.printf("Média da turma toda: %.2f", mediaTurma);
    }
}
