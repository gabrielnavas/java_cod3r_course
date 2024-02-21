package jpa.learning.orm;

import jpa.learning.orm.umPraUm.entities.Assento;
import jpa.learning.orm.umPraUm.entities.Cliente;
import jpa.learning.orm.umPraUm.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmApplication.class, args);
	}

}
