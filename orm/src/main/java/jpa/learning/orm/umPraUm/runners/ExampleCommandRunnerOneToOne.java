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
public class ExampleCommandRunnerOneToOne {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AssentoRepository assentoRepository;

    // é preciso ter o 'assento' já no banco de dados.
    // mas como to usando o @transactional, não preciso seguir a ordem correta.
    // ele insere o assento primeiro automaticamente, usando o transaction,
    // mas é mais perfomático na ordem correta
    @Bean
    @Transactional
    public CommandLineRunner run() {
        return args -> {
//            example2();
        };
    }

    private void example1() {
        Assento assento = new Assento();
        assento.setName("#1");
        Cliente cliente = new Cliente();
        cliente.setName("mario");

        assento = assentoRepository.save(assento);
        cliente.setAssento(assento);
        clienteRepository.save(cliente);
    }

    private void example2() {
        Assento assento = new Assento();
        assento.setName("#1");
        Cliente cliente = new Cliente();
        cliente.setName("mario");
        cliente.setAssento(assento);

        clienteRepository.save(cliente);

        // printa os ids, indo pelo cliente ou pelo assento, a partir do cliente
        clienteRepository.findById(cliente.getId()).ifPresent(c -> {
            System.out.println(c.getAssento().getId()); // printa o id do assento pelo cliente
            System.out.println(c.getAssento().getCliente().getId()); // printa o id do cliente pelo assento
        });

        // printa os ids, indo pelo cliente ou pelo assento, a partir do cliente
        assentoRepository.findById(assento.getId()).ifPresent(as -> {
            System.out.println(as.getCliente().getId()); // printa o id do cliente pelo assento
            System.out.println(as.getCliente().getAssento().getId()); // printa o id do assento pelo cliente
        });
    }
}
