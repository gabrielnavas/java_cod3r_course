package fundamentos;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {

        // tipos de out print
        System.out.print("Bom");
        System.out.print(" dia!\n");

        System.out.println("Bom dia!");

        System.out.printf("Megasena: %d %d %d %d %d %d%n", 1, 2, 3, 4, 5, 6);

        System.out.printf("Salário %.2f\n", 1234.5678);

        // entrada de dados via teclado
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();
        System.out.printf("Nome digitado foi %s\n", nome); // saida do nome digitado

        System.out.print("Digite sua idade: ");
        int idade = entrada.nextInt();
        System.out.printf("Idade digitada foi %d\n", idade); // saida do nome digitado

        entrada.close(); // fechar o scanner
    }
}
