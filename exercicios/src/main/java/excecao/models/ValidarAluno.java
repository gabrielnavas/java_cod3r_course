package excecao.models;


import excecao.NumeroNegativoException;

public class ValidarAluno {

    public void validar(Aluno aluno) throws NumeroNegativoException {
        if(aluno == null) {
            throw new IllegalArgumentException("aluno is null");
        }

        if(aluno.getNota() < 0) {
            throw new NumeroNegativoException("nota do aluno esta negativa");
        }
    }
}
