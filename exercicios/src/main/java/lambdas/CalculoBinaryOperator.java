package lambdas;

import java.util.function.BinaryOperator;

public class CalculoBinaryOperator {
    public static void main(String[] args) {
        BinaryOperator<Double> calculo = (x, y) -> x + y;
        System.out.println(calculo.apply(2.0, 4.));
    }
}
