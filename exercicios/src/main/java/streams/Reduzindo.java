package streams;

import java.util.Arrays;
import java.util.List;

public class Reduzindo {
    public static void main(String[] args) {
        List<Double> numeros = Arrays.asList(2.0, 4.0, 6.0, 8.0);

        Double soma = numeros.stream().reduce(0.0, Double::sum);
        System.out.println(soma);
    }
}
