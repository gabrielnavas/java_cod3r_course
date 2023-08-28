package colecoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lista {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios1 = new ArrayList<>();
        usuarios1.add(new Usuario("João"));
        usuarios1.add(new Usuario("Maria"));
        usuarios1.add(new Usuario("Lucas"));


        List<Usuario> usuarios2 = new ArrayList<>();
        usuarios2.add(new Usuario("Felipe"));
        usuarios2.add(new Usuario("Márcio"));

        for (Usuario u : usuarios1) {
            System.out.println(u); // imprime por causa do to string
        }

        System.out.println(usuarios1.get(1)); // Maria

        Usuario felipe = usuarios2.remove(0);
        boolean removidoMarcio = usuarios2.remove(new Usuario("Márcio"));
        System.out.println(felipe); // Felipe
        System.out.println(removidoMarcio); // true, usa o método equals da classe Usuario

        boolean temMaria = usuarios2.contains(new Usuario("Maria"));
        System.out.println(temMaria); // false
    }
}
