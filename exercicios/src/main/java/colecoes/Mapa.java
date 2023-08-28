package colecoes;

import java.util.HashMap;
import java.util.Map;

public class Mapa {
    public static void main(String[] args) {
        Map<String, Usuario> usuarios = new HashMap<>();

        usuarios.put("123.123.123-12", new Usuario("João"));
        usuarios.put("321.123.123-12", new Usuario("Maria"));
        usuarios.put("123.123.321-12", new Usuario("Lucas"));
        usuarios.put("123.123.123-21", new Usuario("Pedro"));

        System.out.println(usuarios.size()); // 4
        System.out.println(usuarios.get("123.123.123-12")); // João
        System.out.println(usuarios.keySet()); // [123.123.123-21, 123.123.123-12, 321.123.123-12, 123.123.321-12]
        System.out.println(usuarios.values()); // [Pedro, João, Maria, Lucas]
        System.out.println(usuarios.entrySet()); // [123.123.123-21=Pedro, 123.123.123-12=João, 321.123.123-12=Maria, 123.123.321-12=Lucas]
        System.out.println(usuarios.containsKey("123.123.123-12")); // true
        System.out.println(usuarios.containsValue(new Usuario("João"))); // true

        for (Map.Entry<String, Usuario> entry: usuarios.entrySet()) {
            System.out.printf("Chave: %s, Valor: %s\n", entry.getKey(), entry.getValue());
        }

    }
}
