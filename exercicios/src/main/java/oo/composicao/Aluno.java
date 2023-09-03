package oo.composicao;

import java.util.ArrayList;

public class Aluno {
    private final String nome;
    private final ArrayList<Curso> cursos;

    public Aluno(String nome) {
        this.nome = nome;
        cursos = new ArrayList<>();
    }

    public void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
        curso.adicionarAluno(this);
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }
}
