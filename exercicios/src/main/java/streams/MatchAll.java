package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MatchAll {
    public static void main(String[] args) {
        List<Double> notas = Arrays.asList(2.0, 4.7, 8.7, 5.3);

        Predicate<Double> aprovado = n -> n > 7.0;

        Boolean todosAlunosAprovados = notas.stream().allMatch(aprovado);
        System.out.printf("todos alunos aprovados? %b\n", todosAlunosAprovados);
    }
}
