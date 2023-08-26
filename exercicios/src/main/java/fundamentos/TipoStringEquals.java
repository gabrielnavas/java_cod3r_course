package fundamentos;

import java.util.Scanner;

public class TipoStringEquals {
    public static void main(String[] args) {
        System.out.println("2" == "2"); // true

        String s1 = new String("2");
        System.out.println("2" == s1); // false
        System.out.println("2".equals("2")); // true

        Scanner entrada = new Scanner(System.in);

        String s2 = entrada.next();

        boolean equals = s1.equals(s2.trim());
        System.out.println(equals);
        System.out.println(equals);

        entrada.close();
    }
}
 