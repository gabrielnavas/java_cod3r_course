package fundamentos;

import java.util.Scanner;

public class DesafioConversao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String virgula = ",";
        String ponto = ".";

        System.out.print("Digite o primeiro salário: ");
        double salario1 = Double.valueOf(entrada.nextLine().replace(virgula, ponto));
        System.out.print("Digite o segundo salário: ");
        double salario2 = Double.valueOf(entrada.nextLine().replace(virgula, ponto));
        System.out.print("Digite o terceiro salário: ");
        double salario3 = Double.valueOf(entrada.nextLine().replace(virgula, ponto));

        double mediaSalario = (salario1 + salario2 + salario3) / 3;

        System.out.printf("\nMédia dos salários do funcionário é: %.2f", mediaSalario);
    }
}
