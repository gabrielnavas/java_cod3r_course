package excecao.exemplos;

import excecao.NumeroNegativoException;
import excecao.models.Aluno;
import excecao.models.ValidarAluno;

public class AlunoMain {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Jack", -1.0);
        ValidarAluno validarAluno = new ValidarAluno();

        try {
            validarAluno.validar(aluno);
        }
        catch (NumeroNegativoException | IllegalArgumentException ex) {
            System.out.printf("deu problema: %s%n\n", ex.getMessage());
        }
    }
}
