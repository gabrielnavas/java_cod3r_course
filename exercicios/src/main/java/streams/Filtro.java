package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtro {
    public static void main(String[] args) {
        exemploFilterSemInterface();
        exemploFilterComInterface();
    }

    private static void exemploFilterSemInterface() {
        List<Double> numeros = Arrays.asList(2.0, 4.0, 6.0, 8.0);
        List<Double> moreThanFour = numeros.stream()
                .filter(n -> n > 4)
                .collect(Collectors.toList());
        moreThanFour.forEach(System.out::println);
    }

    private static void exemploFilterComInterface() {
        List<Double> numeros = Arrays.asList(2.0, 4.0, 6.0, 8.0);
        Predicate<Double> aprovado = n -> n > 6;
        List<Double> aprovados = numeros.stream()
                .filter(aprovado)
                .collect(Collectors.toList());
        aprovados.forEach(System.out::println);
    }
}
