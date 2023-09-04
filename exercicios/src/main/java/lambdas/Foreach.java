package lambdas;

import java.util.Arrays;
import java.util.List;

public class Foreach {
    public static void main(String[] args) {
        List<String> aprovados = Arrays.asList("Ana", "Bia", "Lia", "Gui");

        // passando explicitamente o aprovado
        aprovados.forEach(aprovado -> System.out.println(aprovado));

        // passadno implicitamente o aprovado
        aprovados.forEach(System.out::println);
    }
}
