package classe;

public class Produto {
    String nome;
    double preco;
    static double desconto = 0.00; // 0.0 .. 1.0

    Produto() {
        nome = "";
        preco = 0.00;
    }

    Produto(String nomeInicial, double precoInicial) {
        nome = nomeInicial;
        preco = precoInicial;
    }

    /***
     *
     * @param descontoDoGerente entre 0.0 .. 1.0
     * @return
     */
    double precoComDesconto(double descontoDoGerente) {
        return preco * (1 - Produto.desconto + descontoDoGerente);
    }

    double precoComDesconto() {
        return preco * (1 - Produto.desconto);
    }
}
