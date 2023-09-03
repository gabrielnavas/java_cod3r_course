package oo.composicao;

import java.util.ArrayList;

public class Curso {
    private final String nome;
    private final ArrayList<Aluno> alunos;

    public Curso(String nome) {
        this.nome = nome;
        alunos = new ArrayList<>();
    }

    void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
        aluno.getCursos().add(this);
    }

    public Aluno obterAlunoPorNome(String nome) {
        Aluno aluno = null;

        for (Aluno a : this.alunos) {
            if (a.getNome().equals(nome)) {
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

    public String getNome() {
        return nome;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
}
