package oo.composicao;

import java.util.ArrayList;

public class Compra {

    String nomeCliente;
    ArrayList<Item> itens;

    Compra(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        itens = new ArrayList<>();
    }

    void adicionarItem(Item item) {
        item.compra = this;
        itens.add(item);
    }

    void adicionarItem(String nome, int quantidade, double preco) {
        Item item = new Item(nome, quantidade, preco);
        item.compra = this;
        itens.add(item);
    }

    double obterValorTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.preco * item.quantidade;
        }
        return total;
    }
}
