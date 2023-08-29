package oo.composicao.desafio;

public class Item {

    final Compra compra;
    final Produto produto;

    final int quantidade;
    final double preco;

    final double desconto; // 0.0..1.0

    Item(Compra compra, Produto produto, int quantidade, double preco, double desconto) {
        this.produto = produto;
        this.compra = compra;
        this.quantidade = quantidade;
        this.preco = preco;
        this.desconto = desconto;
    }

    double obterGasto() {
        return this.quantidade * this.preco * (1 - this.desconto);
    }
}
