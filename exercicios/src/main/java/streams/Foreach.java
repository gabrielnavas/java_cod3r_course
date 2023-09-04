package streams;

import java.util.Arrays;
import java.util.List;

public class Foreach {
    public static void main(String[] args) {
        List<String> aprovados = Arrays.asList("Lucas", "Luciana", "Fábio");
        for (String aprovado : aprovados) {
            System.out.println(aprovado);
        }
    }
}
