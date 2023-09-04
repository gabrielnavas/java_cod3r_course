package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mapeando {
    public static void main(String[] args) {
        exemploMapSemInterface();
        exemploMapComInterface();
    }

    private static void exemploMapSemInterface() {
        List<Double> numeros = Arrays.asList(2.0, 4.0, 6.0, 8.0);
        List<Double> mapped = numeros.stream()
                .map(n -> n + 2)
                .collect(Collectors.toList());
        mapped.forEach(System.out::println);
    }

    private static void exemploMapComInterface() {
        List<Double> numeros = Arrays.asList(2.0, 4.0, 6.0, 8.0);
        Function<Double, Double> adicionaDoisPontos = n -> n + 2;
        List<Double> mapped = numeros.stream()
                .map(adicionaDoisPontos)
                .collect(Collectors.toList());
        mapped.forEach(System.out::println);
    }
}
