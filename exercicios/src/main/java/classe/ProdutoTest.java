package classe;

import java.util.Scanner;

public class ProdutoTest {
    public static void main(String[] args) {
        Produto produto1 = new Produto();
        produto1.nome = "Porta";
        produto1.desconto = 0.20;
        produto1.preco = 79.90;

        System.out.println("Saída do produto 1");
        System.out.printf("Nome: %s\n", produto1.nome);
        System.out.printf("Preço com desconto: %.2f\n", produto1.preco * (1 - produto1.desconto));

        Produto produto2 = new Produto();
        produto2.nome = "Janela";
        produto2.desconto = 0.10;
        produto2.preco = 149.90;

        System.out.println("\nSaída do produto 2");
        System.out.printf("Nome: %s\n", produto2.nome);
        System.out.printf("Preço com desconto: %.2f\n", produto2.preco * (1 - produto2.desconto));

        System.out.printf("Média dos preços dos produtos descontados %.2f\n", (produto1.preco * (1 - produto1.desconto) + produto2.preco * (1 - produto2.desconto)) / 2);
    }
}
