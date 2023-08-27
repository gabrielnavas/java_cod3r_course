package fundamentos;

import java.util.Scanner;

public class DesafioCalculadora {
    public static void main(String[] args) {
        // sem if ou switch

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double num1 = Double.valueOf(entrada.nextLine().trim());

        System.out.print("Digite o segundo número: ");
        double num2 = Double.valueOf(entrada.nextLine().trim());

        System.out.print("Digite a operação desejada: [+ - * / %]");
        String operacao = entrada.nextLine().trim();

        double resultado = "+".equals(operacao) ? num1 + num2 : 0.00;
        resultado = "-".equals(operacao) ? num1 - num2 : resultado;
        resultado = "*".equals(operacao) ? num1 * num2 : resultado;
        resultado = "/".equals(operacao) ? num1 / num2 : resultado;
        resultado = "%".equals(operacao) ? num1 % num2 : resultado;

        System.out.printf("Resultado foi %.2f %s %.2f = %.2f.", num1, operacao, num2, resultado);

        entrada.close();
    }
}
