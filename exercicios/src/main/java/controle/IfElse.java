package controle;

import javax.swing.*;

public class IfElse {
    public static void main(String[] args) {
        String valor = JOptionPane.showInputDialog("Informe o número:");
        int numero = Integer.parseInt(valor);

        boolean par;
        if(numero % 2 == 0) {
            par  = true;
        } else {
            par  = false;
        }
        System.out.printf("Número é %s.\n", par ? "par" : "impar");
    }
}
