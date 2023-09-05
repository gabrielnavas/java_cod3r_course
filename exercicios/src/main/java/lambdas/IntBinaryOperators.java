package lambdas;

import java.util.function.IntBinaryOperator;

public class IntBinaryOperators {
    public static void main(String[] args) {
        IntBinaryOperator h = (x, y) -> x + y;
        System.out.println(h.applyAsInt(2, 4));
    }
}
