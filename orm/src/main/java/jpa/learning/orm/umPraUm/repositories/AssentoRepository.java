package jpa.learning.orm.umPraUm.repositories;

import jpa.learning.orm.umPraUm.entities.Assento;
import jpa.learning.orm.umPraUm.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssentoRepository extends JpaRepository<Assento, Long> {
}
