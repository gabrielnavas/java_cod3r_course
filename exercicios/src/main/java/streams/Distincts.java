package streams;

import streams.models.Aluno;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Distincts {
    public static void main(String[] args) {
        // A idéia aqui é pegar somente um dos elementos, sem repetir

        List<Aluno> alunos = Arrays.asList(
                new Aluno("Joao", 2.2),
                new Aluno("Joao", 2.2),
                new Aluno("Joao", 2.2),
                new Aluno("Pedro", 2.2),
                new Aluno("Pedro", 2.2),
                new Aluno("Pedro", 2.2),
                new Aluno("Fábio", 5.2),
                new Aluno("Letícia", 7.2),
                new Aluno("Letícia", 8.2)
        );

        List<Aluno> duplicados = alunos.stream().distinct().collect(Collectors.toList());
        duplicados.forEach(System.out::println);
    }
}
