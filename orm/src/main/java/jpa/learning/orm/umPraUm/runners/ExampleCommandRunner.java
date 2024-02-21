package jpa.learning.orm.umPraUm.runners;

import jakarta.transaction.Transactional;
import jpa.learning.orm.umPraUm.entities.Assento;
import jpa.learning.orm.umPraUm.entities.Cliente;
import jpa.learning.orm.umPraUm.repositories.AssentoRepository;
import jpa.learning.orm.umPraUm.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExampleCommandRunner{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AssentoRepository assentoRepository;

    @Bean
    @Transactional
    public CommandLineRunner run() {
        return args -> {
            Assento assento = new Assento();
            assento.setName("#1");
            Cliente cliente = new Cliente();
            cliente.setName("mario");

            // é preciso ter o assento já no banco de dados.
            // mas como to usando o transactional, não preciso seguir essa ordem.
            // ele insere o assento primeiro automaticamente, usando o transaction,
            // mas é mais perfomático na ordem correta
            assento=assentoRepository.save(assento);
            cliente.setAssento(assento);
            clienteRepository.save(cliente);

            // printa todos os clientes
            for(Cliente c : clienteRepository.findAll()) {
                System.out.printf("id: %d nome: %s nome do assento: %s%n", c.getId(), c.getName(), c.getAssento().getName());
            }
        };
    }
}
