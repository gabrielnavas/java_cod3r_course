package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMax {
    public static void main(String[] args) {
        List<Double> notas = Arrays.asList(1.9, 1.9, 4.2, 5.5);

        Comparator<Double> selecionarNota = (n1, n2) -> {
            if (n1 > n2) {
                return 1;
            }
            if (n1 < n2) {
                return -1;
            }
            return 0;
        };

        Optional<Double> maiorNota = notas.stream().max(selecionarNota);
        maiorNota.ifPresent(System.out::println); // 5.5

        Optional<Double> menorNota = notas.stream().min(selecionarNota);
        menorNota.ifPresent(System.out::println); // 1.9
    }
}
