package oo.composicao;

import java.util.ArrayList;

public class Compra {

    private String nomeCliente;
    private ArrayList<Item> itens;

    public Compra(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        itens = new ArrayList<>();
    }

    void adicionarItem(Item item) {
        item.setCompra(this);
        itens.add(item);
    }

    void adicionarItem(String nome, int quantidade, double preco) {
        Item item = new Item(nome, quantidade, preco);
        item.setCompra(this);
        itens.add(item);
    }

    double obterValorTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
}
