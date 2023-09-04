package lambdas;

import java.util.function.BiFunction;

public class CalculaBiFunction {
    public static void main(String[] args) {
        BiFunction<Double, Integer, String> calculo = (x, y) -> String.valueOf(x + y);

        System.out.println(calculo.apply(2.1, 4));
    }
}
