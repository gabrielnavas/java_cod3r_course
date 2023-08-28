package colecoes;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConjuntoComportado {
    public static void main(String[] args) {

        // HashSet não garante a ordem de inserção
        Set<String> nomes = new HashSet<>();
        nomes.add("João");
        nomes.add("Maria");
        nomes.add("Ana");
        nomes.add("Júlia");

        for (String nome : nomes) {
            System.out.println(nome);
        }

        // TreeSet garante a ordem de inserção, podendo usar o SortedSet como interface ou Set também
//        Set<String> carros = new TreeSet<>();
        SortedSet<String> carros = new TreeSet<>();
        carros.add("Ferrari");
        carros.add("Fusca");
        carros.add("Gol");
        carros.add("Uno");

        for (String carro : carros) {
            System.out.println(carro);
        }
    }
}
