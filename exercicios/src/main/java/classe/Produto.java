package classe;

public class Produto {
    String nome;
    double preco;
    double desconto; // 0.0 .. 1.0

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
