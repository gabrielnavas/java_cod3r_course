package excecao;

public class ChecadaVsNaoChecada {
    public static void main(String[] args) {
        gerarError1();
        gerarError2();
    }

    static void gerarError1() {
        new RuntimeException("Ocorreu um error bem legal #01!");
    }

    static void gerarError2() {
        new Exception("Ocorreu um error bem legal #01!");
    }

}
