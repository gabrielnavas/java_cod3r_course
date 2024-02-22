package jpa.learning.orm.muitoParaMuitos.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "aluno")
    private Set<AlunoCurso> alunoCursos;


    public Aluno() {
        this(0L, "", new HashSet<>());
    }

    public Aluno(Long id, String nome, Set<AlunoCurso> alunoCursos) {
        this.id = id;
        this.nome = nome;
        this.alunoCursos = alunoCursos;
    }

    public Aluno(String nome, Set<AlunoCurso> alunoCursos) {
        this(0L, nome, alunoCursos);
    }


    public Aluno(String nome) {
        this(0L, nome, new HashSet<>());
    }
}
