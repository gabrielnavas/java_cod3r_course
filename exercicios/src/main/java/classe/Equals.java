package classe;

import java.util.Date;

public class Equals {
    public static void main(String[] args) {
        Usuario u1 = new Usuario();
        u1.setNome("Pedro Silva");
        u1.setEmail("pedro.silva@ezemail.com.br");

        Usuario u2 = new Usuario();
        u2.setNome("Pedro Silva");
        u2.setEmail("pedro.silva@ezemail.com.br");

        System.out.println(u1 == u2); // false
        System.out.println(u1.equals(null)); // false
        System.out.println(u1.equals(new Date())); // false
        System.out.println(u1.equals(u2)); // true
        System.out.println(u2.equals(u1)); // true
        System.out.println(u1.equals(u1)); // true
        System.out.println(u2.equals(u2)); // true
    }
}
