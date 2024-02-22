package jpa.learning.orm.muitoParaMuitos.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "curso")
    private Set<AlunoCurso> alunoCursos;


    public Curso() {
        this(0L, "", new HashSet<>());
    }

    public Curso(String nome) {
        this(0L, nome, new HashSet<>());
    }

    public Curso(String nome, Set<AlunoCurso> alunoCursos) {
        this(0L, nome, alunoCursos);
    }

    public Curso(Long id, String nome, Set<AlunoCurso> alunoCursos) {
        this.id = id;
        this.nome = nome;
        this.alunoCursos = alunoCursos;
    }
}
