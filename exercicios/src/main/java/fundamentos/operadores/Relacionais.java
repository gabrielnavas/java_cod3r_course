package fundamentos.operadores;

public class Relacionais {
    public static void main(String[] args) {

        // operadores relacionais
        boolean igual = 2 == 2; // igualdade true
        boolean maior = 3 > 2; // maior true
        boolean maiorIgual = 2 >= 2; // maior ou igual true
        boolean menor = 1 < 2; // menor true
        boolean menorIgual = 2 <= 2; // menor ou igual true
        boolean diferente = 2 != 4; // diferente true
        double numero = 4; // atribuição

        // coisas interessantes mas difícil de ler para quem não está acostumado.
        int a = 97;
        int b = 'a';
        System.out.println(a == b); // true
        System.out.println(b == '\u0061'); // true
    }
}
