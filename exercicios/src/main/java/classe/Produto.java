package classe;

public class Produto {
    private String nome;
    private double preco;
    public static double desconto = 0.00; // 0.0 .. 1.0

    public Produto() {
        nome = "";
        preco = 0.00;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    /***
     *
     * @param descontoDoGerente entre 0.0 .. 1.0
     * @return
     */
    public double precoComDesconto(double descontoDoGerente) {
        return preco * (1 - Produto.desconto + descontoDoGerente);
    }

    public double precoComDesconto() {
        return preco * (1 - Produto.desconto);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public static double getDesconto() {
        return desconto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
