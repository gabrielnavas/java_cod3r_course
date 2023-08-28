package colecoes;

import java.util.HashSet;

public class Hash {
    public static void main(String[] args) {

        // mais rapido que um List, mas precisa implementar o hasCode do Objeto usado na collection HashSet.
        HashSet<Usuario> usuarios=  new HashSet<>();

        usuarios.add(new Usuario("Pedro"));
        usuarios.add(new Usuario("Maria"));
        usuarios.add(new Usuario("Luiza"));

        boolean resultado = usuarios.contains(new Usuario("Maria"));
        System.out.println(resultado); // true
    }
}
