package classe;

public class ValorPadrao {

    private String nome;
    private double preco;

    private final int x = 42;

    public static int y;

    public static void main(String[] args) {
        // valor padrão

        // byte, short, int, long -> 0
        // float, double -> 0.0
        // bolean -> false
        // char -> '\u0000'
        // Objetos -> null

        ValorPadrao vp = new ValorPadrao();
        System.out.println(vp.getPreco()); // 0.0
        System.out.println(vp.getNome()); // null
        System.out.println(vp.getX()); // precisa ser definido constantes

        System.out.println(y); // 0
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getX() {
        return x;
    }
}
