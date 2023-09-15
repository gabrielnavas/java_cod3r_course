package excecao.exemplos;

import java.util.Scanner;

public class Finally {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            String valor = scanner.nextLine();
            System.out.println(10 / Integer.valueOf(valor));
        } catch (Exception ex) {
            System.out.printf("deu erro: %s\n", ex.getMessage());
        }
        finally {
            scanner.close();
        }
    }
}
