package jpa.learning.orm.muitoParaMuitos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "aluno_curso")
public class AlunoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @ManyToOne(cascade = CascadeType.ALL) // o aluno não precisa existir na base, sera inserido automaticamente.
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    //    @ManyToOne(cascade = CascadeType.ALL) // o aluno não precisa existir na base, sera inserido automaticamente.
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public AlunoCurso() {
        this(0L, null, null);
    }

    public AlunoCurso(Long id, Aluno aluno, Curso curso) {
        this.id = id;
        this.aluno = aluno;
        this.curso = curso;
    }

    public AlunoCurso(Aluno aluno, Curso curso) {
        this(0L, aluno, curso);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
