package oo.composicao;

import java.util.ArrayList;

public class Aluno {
    final String nome;
    final ArrayList<Curso> cursos;

    Aluno(String nome) {
        this.nome = nome;
        cursos = new ArrayList<>();
    }

    void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
        curso.adicionarAluno(this);
    }

    @Override
    public String toString() {
        return nome;
    }
}
