package classe;

public class ProdutoTeste {
    public static void main(String[] args) {
        Produto.desconto = 0.10;
        Produto produto1 = new Produto("Porta", 110.00);

        System.out.println("Saída do produto 1");
        System.out.printf("Nome: %s\n", produto1.getNome());
        System.out.printf("Preço com desconto: %.2f\n", produto1.precoComDesconto());

        Produto produto2 = new Produto();
        produto2.setNome("Janela");
        produto2.desconto = 0.10;
        produto2.setPreco(149.90);

        System.out.println("\nSaída do produto 2");
        System.out.printf("Nome: %s\n", produto2.getNome());
        System.out.printf("Preço com desconto: %.2f\n", produto2.precoComDesconto(0.10));

        System.out.printf("Média dos preços dos produtos descontados %.2f\n", (produto1.precoComDesconto() + produto2.precoComDesconto(0.10)) / 2);
    }
}
