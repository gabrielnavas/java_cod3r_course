package oo.composicao;

import java.util.ArrayList;

public class Curso {
    final String nome;
    final ArrayList<Aluno> alunos;

    Curso(String nome) {
        this.nome = nome;
        alunos = new ArrayList<>();
    }

    void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
        aluno.cursos.add(this);
    }

    Aluno obterAlunoPorNome(String nome) {
        Aluno aluno = null;

        for (Aluno a : this.alunos) {
            if (a.nome.equals(nome)) {
                aluno = a;
                break;
            }
        }

        return aluno;
    }

    @Override
    public String toString() {
        return nome;
    }
}
