package colecoes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    public static void main(String[] args) {
        Queue<String> banco = new LinkedList<>();

        banco.add("Carla");
        banco.offer("Bia");
        banco.add("João");
        banco.offer("Tânia");
        banco.add("Maria");
        banco.offer("Lucas");
        banco.add("Felipe");
        banco.offer("Miguel");

        String primeiroElemento = banco.peek();
        System.out.println(primeiroElemento); // Carla ou null se a fila estiver vazia

        primeiroElemento = banco.element();
        System.out.println(primeiroElemento); // Carla ou NoSuchElementException se a fila estiver vazia

        boolean carlaAtendida = banco.remove("Carla");
        System.out.println(carlaAtendida); // true

        boolean carlaEstaNaFila = banco.contains("Carla");
        System.out.println(carlaEstaNaFila); // false

        boolean biaEstaNaFila = banco.contains("Bia");
        System.out.println(biaEstaNaFila); // true

        System.out.println(banco.poll()); // pega o próximo da fila e já remove
        System.out.println(banco.poll()); // pega o próximo da fila e já remove
        System.out.println(banco.poll()); // pega o próximo da fila e já remove
        System.out.println(banco.poll()); // pega o próximo da fila e já remove
        System.out.println(banco.poll()); // pega o próximo da fila e já remove
        System.out.println(banco.poll()); // pega o próximo da fila e já remove
        System.out.println(banco.poll()); // pega o próximo da fila e já remove
        System.out.println(banco.poll()); // false
//        System.out.println(banco.remove()); // faz igual o poll, mas levanta uma exception se a fila tiver vazia

        banco.clear();
        boolean filaVazia = banco.isEmpty();
        System.out.println(filaVazia); // true
    }
}
