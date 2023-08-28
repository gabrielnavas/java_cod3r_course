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
            System.out.println(u.nome);
        }

        System.out.println(usuarios1.get(1).nome); // Maria
    }
}
