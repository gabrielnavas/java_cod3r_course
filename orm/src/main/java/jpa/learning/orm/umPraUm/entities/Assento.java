package jpa.learning.orm.umPraUm.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "tb_assento")
@Table(name = "tb_assento")
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // isso informa que a relação one to one foi mapeada pelo assento
    // isso faz com que não seja criado uma colina na tabela tb_assento
    // relações one to one, apenas uma tabela deve ter a relação
    // essa referência será apenas para ter acesso ao cliente aqui no objeto assento
    @OneToOne(mappedBy = "assento")
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assento assento = (Assento) o;
        return Objects.equals(id, assento.id) && Objects.equals(name, assento.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
