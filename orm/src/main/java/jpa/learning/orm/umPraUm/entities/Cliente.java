package jpa.learning.orm.umPraUm.entities;

import jakarta.persistence.*;

import java.util.Objects;

/*
 * Apenas um lado tem referência para a outra relação.
 *
 * Quem tiver desenvolvendo o sistema, deve se pergntar qual é mais fácil
 * Através do cliente obter o assento ou o através do assento obter o cliente.
 *
 * Nesse caso foi escolhiddo atraves do cliente obter o assento
 * */

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = {
            CascadeType.PERSIST // quando o registro do cliente for salvo, o assento será também
    })
    @JoinColumn(
            name = "assento_id", // nome da coluna na tabela
            unique = true // garantir que só existirá um cliente com o assento definido
    )
    private Assento assento;

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(name, cliente.name) && Objects.equals(assento, cliente.assento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, assento);
    }
}
