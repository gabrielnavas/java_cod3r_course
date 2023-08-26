package fundamentos.operadores;

public class Atribuicao {
    public static void main(String[] args) {
        int a = 3; // atribuição
        int b = a; // atribuição
        int c = a + b; // atribuição

        c = c + b; // atribuição
        c += b; // forma de atribuição de soma simplificada

        c = c - b; // forma de atribuição de subtração simplificada
        c -= b; // forma de atribuição de subtração simplificada

        c = c * b; // forma de atribuição de multiplicação simplificada
        c *= b; // forma de atribuição de multiplicação simplificada

        c = c / b; // forma de atribuição de divisão simplificada
        c /= b; // forma de atribuição de divisão simplificada

        c = c % b; // forma de atribuição de resto simplificada
        c %= b; // forma de atribuição de resto simplificada
    }
}
