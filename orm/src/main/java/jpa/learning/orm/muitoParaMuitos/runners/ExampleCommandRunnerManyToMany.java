package jpa.learning.orm.muitoParaMuitos.runners;

import jakarta.transaction.Transactional;
import jpa.learning.orm.muitoParaMuitos.entities.Aluno;
import jpa.learning.orm.muitoParaMuitos.entities.AlunoCurso;
import jpa.learning.orm.muitoParaMuitos.entities.Curso;
import jpa.learning.orm.muitoParaMuitos.repositories.AlunoCursoRepository;
import jpa.learning.orm.muitoParaMuitos.repositories.AlunoRepository;
import jpa.learning.orm.muitoParaMuitos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExampleCommandRunnerManyToMany {

    @Autowired
    private AlunoCursoRepository alunoCursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Bean
    public CommandLineRunner runManyToMany() {
        return args -> {
            example1();
        };
    }

    @Transactional
    private void example1() {
        Aluno aluno = new Aluno("John");
        Curso curso = new Curso("Operation System II");

        alunoRepository.save(aluno);
        cursoRepository.save(curso);

        AlunoCurso alunoCurso = new AlunoCurso();
        alunoCurso.setAluno(aluno);
        alunoCurso.setCurso(curso);

        alunoCursoRepository.save(alunoCurso);

        for (AlunoCurso ac : alunoCursoRepository.findAll()) {
            System.out.println(ac.getId());
        }
    }
}
