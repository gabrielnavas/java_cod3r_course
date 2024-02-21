package jpa.learning.orm.umPraUm.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // isso informa que a relação one to one foi mapeada pelo Assento
    // o atributo que realmente mapeia é o atributo assento que está dentro de Cliente
    // isso faz com que não seja criado uma coluna na tabela tb_assento
    // relações one to one, apenas uma tabela deve ter a relação
    // essa referência será apenas para ter acesso ao cliente aqui no objeto assento
    @OneToOne(mappedBy = "assento")
    private Cliente cliente;

    public Long getId() {
        return id;
    }


    public Cliente getCliente() {
        return cliente;
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
