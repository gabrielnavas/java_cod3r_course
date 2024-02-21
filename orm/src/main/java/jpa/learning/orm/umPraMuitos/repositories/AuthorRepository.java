package jpa.learning.orm.umPraMuitos.repositories;

import jpa.learning.orm.umPraMuitos.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
