package fundamentos.operadores;

import java.util.Scanner;

public class DesafiosLogicos {
    public static void main(String[] args) {
        // Trabalho na terça (V ou F)
        // Trabalho na quinta (V ou F)
        // Comprar TV 50" se trabalho terça e quinta for V
        // Comprar TV 32" se trabalho terça ou quinta for V
        // Se comprar qualquer TV 50" OU 32" a família vai comprar sorvete
        // Ficar em casa senão comprar nenhuma TV

        Scanner entrada = new Scanner(System.in);

        System.out.println("Recebeu o dinheiro de terça-feira? Digite true ou false");
        boolean trabalhoTerca = entrada.nextBoolean();

        System.out.println("Recebeu o dinheiro de terça-feira? Digite true ou false");
        boolean trabalhoQuinta = entrada.nextBoolean();

        boolean comprarTV50 = trabalhoTerca & trabalhoQuinta;
        boolean comprarTV32 = trabalhoTerca ^ trabalhoQuinta;

        boolean familiaTomarSorvete = comprarTV50 | comprarTV32;

        boolean ficarEmcasaSemTVSemSorvete = !comprarTV50 & !comprarTV32;

        System.out.printf("Recebeu dinheiro do trabalho da terça-feira? %b", trabalhoTerca);
        System.out.printf("\nRecebeu dinheiro do trabalho da quinta-feira? %b", trabalhoQuinta);

        System.out.printf("\nComprou TV 50 Polegadas? %b", comprarTV50);
        System.out.printf("\nComprou TV 32 Polegadas? %b", comprarTV32);


        System.out.printf("\nFamília foi tomar sorvete? %b", familiaTomarSorvete);

        System.out.printf("\nFamília ficou em casa sem TV e sem sorvete? %b", ficarEmcasaSemTVSemSorvete);
    }
}
