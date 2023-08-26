package fundamentos.operadores;

public class Unarios {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        System.out.println(++a == b--); // true, pois o a é incrementado antes e depois é comparado com o valor de b, só depois da comparação o b é incrementado
        System.out.println(b == 1); // b == 1 => true

        ++a; // pré fixado
        a++; // pré fixado
        a = a + 1; // in fix

        --a; // pré fixado
        a--; // pré fixado
        a = a - 1; // in fix
    }
}
