package classe;

public class Produto {
    String nome;
    double preco;
    double desconto; // 0.0 .. 1.0

    Produto() {
        nome = "";
        preco = 0.00;
        desconto = 0.00;
    }

    Produto(String nomeInicial, double precoInicial, double descontoInicial) {
        nome = nomeInicial;
        preco = precoInicial;
        desconto = descontoInicial;
    }

    /***
     *
     * @param descontoDoGerente entre 0.0 .. 1.0
     * @return
     */
    double precoComDesconto(double descontoDoGerente) {
        return preco * (1 - desconto + descontoDoGerente);
    }

    double precoComDesconto() {
        return preco * (1 - desconto);
    }
}
