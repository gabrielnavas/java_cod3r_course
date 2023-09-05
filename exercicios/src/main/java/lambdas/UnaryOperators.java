package lambdas;

import java.util.function.UnaryOperator;

public class UnaryOperators {
    public static void main(String[] args) {
        UnaryOperator<Double> c = x -> x;
        System.out.println(c.apply(42.42));
    }
}
