package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduzindo {
    public static void main(String[] args) {
        List<Double> numeros = Arrays.asList(2.0, 4.0, 6.0, 8.0);
        exemploReduceSemInterface(numeros);
        exemploReduceComInterface(numeros);
    }

    private static void exemploReduceSemInterface(List<Double> numeros) {
        Double soma = numeros.stream().reduce(0.0, Double::sum);
        System.out.println(soma);
    }

    private static void exemploReduceComInterface(List<Double> numeros) {
        BinaryOperator<Double> somando = (sum, n) -> sum + n;
        Double soma = numeros.stream().reduce(0.0, somando);
        System.out.println(soma);
    }
}
