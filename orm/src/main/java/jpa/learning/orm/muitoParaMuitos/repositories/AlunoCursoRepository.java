package jpa.learning.orm.muitoParaMuitos.repositories;

import jpa.learning.orm.muitoParaMuitos.entities.AlunoCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoCursoRepository extends JpaRepository<AlunoCurso, Long> {
}
