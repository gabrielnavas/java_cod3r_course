package lambdas.predicado;

import java.util.function.Predicate;

public class Predicado {
    public static void main(String[] args) {
        Predicate<Produto> isCaro = produto -> produto.preco * (1 - produto.desconto) > 4500;

        boolean caro = isCaro.test(new Produto("Apple", 5000.0, 0.05));
        System.out.printf("é caro? %b\n", caro);
    }
}

