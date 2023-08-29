package oo;

public class CursoAlunoTest {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("João");
        Aluno a2 = new Aluno("Mário");
        Aluno a3 = new Aluno("Maria");

        Curso c1 = new Curso("Java");
        Curso c2 = new Curso("JavaScript");
        Curso c3 = new Curso("React");


        // relacionamento muito para muitos
        c1.adicionarAluno(a1);
        c1.adicionarAluno(a2);
        c2.adicionarAluno(a3);

        c3.adicionarAluno(a1);

        a1.adicionarCurso(c2);
        a1.adicionarCurso(c3);

        System.out.println("alunos do curso 1");
        for (Aluno aluno : c1.alunos) {
            System.out.println(aluno);
        }

        System.out.println("cursos do aluno 1");
        for (Curso curso : a1.cursos) {
            System.out.println(curso);
        }

        Aluno alunoEncontrado = c1.obterAlunoPorNome("João");
        if(alunoEncontrado != null) {
            System.out.printf("Aluno encontrado: %s\n", alunoEncontrado.nome);
        }
    }
}
