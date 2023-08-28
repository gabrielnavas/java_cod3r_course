package colecoes;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Pilha {
    public static void main(String[] args) {
        Deque<String> livros = new ArrayDeque<>();
        livros.add("Storytelling com dados - Cole Knaflic");
        livros.add("Código limpo - Robert Martin");
        livros.add("Inteligência Artificial - Norvig & Russell");
        livros.add("Código limpo - Robert Martin");
        livros.add("Designing Data Intensive Applications");

        System.out.println(livros.peek()); // pega o topo => Storytelling com dados - Cole Knaflic
        System.out.println(livros.element()); // pega o topo => Storytelling com dados - Cole Knaflic. Lança NoSuchElementException se tiver vazia

        System.out.println(livros.poll()); // retira o topo => Storytelling com dados - Cole Knaflic
        System.out.println(livros.pop()); // retira o topo => Código limpo - Robert Martin. Lança NoSuchElementException se tiver vazia
        System.out.println(livros.remove()); // Inteligência Artificial - Norvig & Russell. Lança NoSuchElementException se tiver vazia

        System.out.println(livros.size()); // 2
        System.out.println(livros.contains("Designing Data Intensive Applications")); // true
        livros.clear();
        System.out.println(livros.isEmpty()); // true
    }
}
