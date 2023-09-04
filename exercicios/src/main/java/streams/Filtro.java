package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtro {
    public static void main(String[] args) {
        List<Double> numeros = Arrays.asList(2.0, 4.0, 6.0, 8.0);
        List<Double> moreThanFour = numeros.stream().filter(n -> n > 4).collect(Collectors.toList());
        moreThanFour.forEach(System.out::println);
    }
}
