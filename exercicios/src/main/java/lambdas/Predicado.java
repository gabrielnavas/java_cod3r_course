package lambdas;

import lambdas.models.Produto;

import java.util.function.Predicate;

public class Predicado {
    public static void main(String[] args) {
        Predicate<Produto> isCaro = produto -> produto.getPreco() * (1 - produto.getDesconto()) > 4500;

        boolean caro = isCaro.test(new Produto("Apple", 5000.0, 0.05));
        System.out.printf("é caro? %b\n", caro);
    }
}

