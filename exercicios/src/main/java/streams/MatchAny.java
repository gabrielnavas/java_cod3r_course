package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MatchAny {
    public static void main(String[] args) {
        List<Double> notas = Arrays.asList(2.0, 4.7, 8.7, 5.3);

        Predicate<Double> aprovado = n -> n > 7.0;

        Boolean algumAlunoAprovado = notas.stream().anyMatch(aprovado);
        System.out.printf("algum aluno aprovado? %b\n", algumAlunoAprovado);
    }
}
