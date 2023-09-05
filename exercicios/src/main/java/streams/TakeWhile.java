package streams;

import streams.models.Aluno;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TakeWhile {
    public static void main(String[] args) {
        // A idéia aqui é fazer paginação

        List<Aluno> alunos = Arrays.asList(
                new Aluno("Joao", 2.5),
                new Aluno("Felipe", 4.8),
                new Aluno("Márcio", 7.0),
                new Aluno("Pedro", 4.2),
                new Aluno("Larissa", 1.2),
                new Aluno("Pedro", 9.2),
                new Aluno("Melissa", 6.2),
                new Aluno("Maria", 7.2),
                new Aluno("Letícia", 8.2)
        );

        Predicate<Aluno> maiorQueDois = aluno -> aluno.getNota() > 2.0;

        List<Aluno> alunosMaiorQueDois = alunos.stream()
                .takeWhile(maiorQueDois)
                .collect(Collectors.toList());

        alunosMaiorQueDois.forEach(System.out::println);
    }
}
