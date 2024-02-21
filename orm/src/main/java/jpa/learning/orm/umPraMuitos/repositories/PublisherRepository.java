package jpa.learning.orm.umPraMuitos.repositories;

import jpa.learning.orm.umPraMuitos.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
