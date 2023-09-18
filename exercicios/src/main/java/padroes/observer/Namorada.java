package padroes.observer;

import java.util.Objects;

public class Namorada implements ObserverChegadaAniversariante {

    private String nome;

    public Namorada(String nome) {
        this.nome = nome;
    }

    public void chegou(EventoChegadaAniversariante evento) {
        System.out.println("Avisar os convidados");
        System.out.println("Apagar as luzes");
        System.out.println("Esperar um pouco...");
        System.out.println("e... surpresa!!!");
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Namorada namorada = (Namorada) o;
        return Objects.equals(nome, namorada.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
