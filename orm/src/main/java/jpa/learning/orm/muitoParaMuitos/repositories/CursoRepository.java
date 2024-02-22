package jpa.learning.orm.muitoParaMuitos.repositories;

import jpa.learning.orm.muitoParaMuitos.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
