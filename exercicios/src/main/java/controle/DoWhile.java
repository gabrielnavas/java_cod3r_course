package controle;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String texto = "";

        do {
            System.out.println("Seja bem vindo!");
            System.out.println("Diga [sair] para sair.");

            System.out.print("-> ");

            texto = entrada.nextLine();

            System.out.printf("Você disse: %s\n", texto);

        } while(!texto.toLowerCase().equals("sair"));
    }
}
