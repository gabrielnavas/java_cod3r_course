package oo.composicao.desafio;

public class LojaTeste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Maria");
        Produto produto = new Produto("TV 50\"\" ");

        Compra compra = new Compra(cliente);
        compra.addProduto(produto, 10, 20.00, 0.50);

        double gastoLoja = compra.obterGasto();
        System.out.printf("Gasto total na loja foi %.2f", gastoLoja);
    }
}
