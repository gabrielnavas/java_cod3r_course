package excecao;

import excecao.models.Aluno;

public class Basico {
    public static void main(String[] args) {
        Aluno alunoNulo = null;

        try {
            imprimirNomeDoAluno(alunoNulo);
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro no momento de imprimir");
        }

        try {
            System.out.println(7 / 0);
        } catch (Exception ex) {
            System.out.printf("Ocorreu ao tentar dividir por zero: %s\n", ex.getMessage());
        }

        System.out.println("Chegou ao fim! :)");
    }

    public static void imprimirNomeDoAluno(Aluno aluno) {
        System.out.println(aluno.getNome());
    }
}
