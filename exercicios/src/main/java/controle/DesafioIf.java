package controle;

public class DesafioIf {
    public static void main(String[] args) {
        double nota = 1.3;

        // aquele ponto e virgula que você nunca achou.
        // mesmo a nota sendo >= 9.0, o bloco de código será executado...
        if(nota >= 9.0); {
            System.out.println("Quadro de honra!");
            System.out.println("Voce é fera!!!");
        }


        // agora esse bloco não será executado.
        if(nota >= 9.0) {
            System.out.println("Quadro de honra!");
            System.out.println("Voce é fera!!!");
        }
    }
}
