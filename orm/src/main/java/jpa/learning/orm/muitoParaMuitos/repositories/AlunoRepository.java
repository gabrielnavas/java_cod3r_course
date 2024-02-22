package jpa.learning.orm.muitoParaMuitos.repositories;

import jpa.learning.orm.muitoParaMuitos.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
