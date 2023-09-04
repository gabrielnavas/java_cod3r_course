package streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Iterador {
    public static void main(String[] args) {
        List<String> aprovados = Arrays.asList("Lucas", "Luciana", "Fábio");

        Iterator<String> aprovadosIterator = aprovados.listIterator();
        while (aprovadosIterator.hasNext()) {
            System.out.println(aprovadosIterator.next());
        }
    }
}
