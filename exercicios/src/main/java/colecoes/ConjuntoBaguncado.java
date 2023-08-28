package colecoes;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoBaguncado {
    public static void main(String[] args) {
        HashSet conjunto = new HashSet();

        conjunto.add("Gabriel");
        conjunto.add(2.22);
        conjunto.add(2.22);
        conjunto.add(1);
        conjunto.add(1);
        conjunto.add(true);
        conjunto.add(true);
        conjunto.add('x');
        conjunto.add('x');

        System.out.printf("Tamanho é: %s\n", conjunto); // [1, 2.22, x, Gabriel, true]
        System.out.printf("Tamanho é: %d\n", conjunto.size()); // 5

        boolean elementoRemovido = conjunto.remove("Gabriel");
        System.out.printf("Removido? %b\n", elementoRemovido);

        boolean temElementoX = conjunto.contains('x');
        System.out.printf("Tem elemento 'x'? %b\n\n", temElementoX);

        // outro conjunto com interface Set, com exemplo de união e intercessão.
        Set numeros1 = new HashSet();
        Set numeros2 = new HashSet();
        Set numeros3 = new HashSet();

        numeros1.add(1);
        numeros1.add(2);
        numeros1.add(3);
        numeros1.add(7);

        numeros2.add(3);
        numeros2.add(4);

        numeros3.add(6);
        numeros3.add(7);

        // União
        numeros2.addAll(numeros1);
        System.out.println(numeros2); // [1, 2, 3, 4, 7]

        // Intercessão
        numeros3.retainAll(numeros2);
        System.out.println(numeros3); // [7]

        // limpar conjunto
        numeros1.clear();
        System.out.println(numeros1); // []
    }
}
