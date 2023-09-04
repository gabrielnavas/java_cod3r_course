package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamForeach {
    public static void main(String[] args) {
        List<String> aprovados = Arrays.asList("Lucas", "Luciana", "Fábio");
        Stream<String> aprovadosStream = aprovados.stream();
        aprovadosStream.forEach(aprovado -> System.out.println(aprovado));
    }
}
