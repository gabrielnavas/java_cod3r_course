package jpa.learning.orm.umPraMuitos.entities;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    //    @ManyToOne(cascade = CascadeType.PERSIST) // o aluno não precisa existir na base, sera inserido automaticamente.
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    //    @ManyToOne(cascade = CascadeType.ALL) // o aluno não precisa existir na base, sera inserido automaticamente.
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Book() {
        this(0L, "", null);
    }

    public Book(Long id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
