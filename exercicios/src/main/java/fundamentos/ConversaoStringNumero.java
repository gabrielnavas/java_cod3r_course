package fundamentos;

import javax.swing.*;
import java.math.BigDecimal;

public class ConversaoStringNumero {
    public static void main(String[] args) {
        String valor1 = JOptionPane.showInputDialog("Digite o primeiro número");
        String valor2 = JOptionPane.showInputDialog("Digite o segundo número");

        double v1 = Double.parseDouble(valor1.toString());
        double v2 = Double.parseDouble(valor2.toString());
        double resultado = v1 + v2;
        System.out.printf("Resultado = %f\n", resultado);
        System.out.printf("Média = %f\n", resultado / 2);
    }
}
