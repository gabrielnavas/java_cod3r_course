package arrays;

import java.util.Arrays;

public class Exercicio {
    public static void main(String[] args) {

        // adicioando valores por index
        double[] notasAlunosA = new double[3];
        notasAlunosA[0] = 7.7;
        notasAlunosA[1] = 6.1;
        notasAlunosA[2] = 4.2;

        for (int i = 0; i < notasAlunosA.length; i++) {
            System.out.println(notasAlunosA[i]);
        }

        System.out.println(Arrays.toString(notasAlunosA));

        // adicionando valor ja na instância
        int[] idades = {10, 20, 30};

        System.out.println(Arrays.toString(idades));
    }
}
