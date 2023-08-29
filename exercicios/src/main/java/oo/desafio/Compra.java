package oo.desafio;

import java.util.ArrayList;

public class Compra {

    final Cliente cliente;
    final ArrayList<Item> itens;

    Compra(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    double obterGasto() {
        double total = 0.0;

        for (Item item : this.itens) {
            total += item.obterGasto();
        }

        return total;
    }

    void addProduto(Produto produto, int quantidade, double preco, double desconto) {
        Item item = new Item(this, produto, quantidade, preco, desconto);
        this.itens.add(item);
    }
}
