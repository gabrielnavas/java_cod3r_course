package classe;

public class ValorPadrao {

    String nome;
    double preco;

    final int x = 42;

    static int y;
    public static void main(String[] args) {
        // valor padrão

        // byte, short, int, long -> 0
        // float, double -> 0.0
        // bolean -> false
        // char -> '\u0000'
        // Objetos -> null

        ValorPadrao vp = new ValorPadrao();
        System.out.println(vp.preco); // 0.0
        System.out.println(vp.nome); // null
        System.out.println(vp.x); // precisa ser definido constantes

        System.out.println(y); // 0
    }
}
