package jpa.learning.orm.umPraMuitos.runners;


import jakarta.transaction.Transactional;
import jpa.learning.orm.umPraMuitos.entities.Author;
import jpa.learning.orm.umPraMuitos.entities.Book;
import jpa.learning.orm.umPraMuitos.entities.Publisher;
import jpa.learning.orm.umPraMuitos.repositories.AuthorRepository;
import jpa.learning.orm.umPraMuitos.repositories.BookRepository;
import jpa.learning.orm.umPraMuitos.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ExampleCommandRunnerOneToMany {

    @Autowired
    private AuthorRepository authorRepository;


    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private PublisherRepository publisherRepository;

    @Bean
    public CommandLineRunner run1() {
        return args -> {
//            example1();
        };
    }

    @Transactional
    private void example1() {
        Book book = new Book();
        book.setTitle("Cool Book");

        Author author = new Author();
        author.setName("John McFish");
        author.setBooks(new ArrayList<>() {{
            add(book);
        }});

        Publisher publisher = new Publisher();
        publisher.setName("Editor LTDA");
        publisher.setBooks(new ArrayList<>() {{
            add(book);
        }});

        // se explicitar que o cascade é CascadeType.PERSIST, não precisa ter os Objetos na base primeiro
        publisherRepository.save(publisher);
        authorRepository.save(author);

        book.setPublisher(publisher);
        book.setAuthor(author);

        bookRepository.save(book);
    }
}
