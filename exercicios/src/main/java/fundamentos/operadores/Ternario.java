package fundamentos.operadores;

public class Ternario {
    public static void main(String[] args) {
        // três operandos
        // uma é a condição que separa dos resultados
        // as outras duas são as respostas para a condição

        double media = 5.6;
        String resultadoRecuperacao = media >= 5.00 ? "em recuperação" : "reprovado";
        String resultado = media >= 7.00 ? "aprovado" : resultadoRecuperacao;

        System.out.printf("O aluno está %s\n", resultado);
    }
}
