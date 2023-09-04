package streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ImprimindoObjetos {
    public static void main(String[] args) {
        List<String> aprovados = Arrays.asList("Lucas", "Luciana", "Fábio");

        usandoForeach(aprovados);
        usandoIterador(aprovados);
        usandoStreamForeach(aprovados);
    }

    private static void usandoForeach(List<String> aprovados) {
        for (String aprovado : aprovados) {
            System.out.println(aprovado);
        }
    }

    private static void usandoIterador(List<String> aprovados) {
        Iterator<String> aprovadosIterator = aprovados.listIterator();
        while (aprovadosIterator.hasNext()) {
            System.out.println(aprovadosIterator.next());
        }
    }

    private static void usandoStreamForeach(List<String> aprovados) {
        Stream<String> aprovadosStream = aprovados.stream();
        aprovadosStream.forEach(aprovado -> System.out.println(aprovado));
    }
}
