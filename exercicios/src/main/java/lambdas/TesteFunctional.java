package lambdas;

import lambdas.models.Calculo;

public class TesteFunctional {
    public static void main(String[] args) {
        Calculo calculo = (x, y) -> x + y;
        System.out.println(calculo.executar(2, 3));

        calculo = (x, y) -> x * y;
        System.out.println(calculo.executar(2, 3));

        System.out.println(calculo.metodoComImplementacaoPode());

        System.out.println(Calculo.metodoStaticPodeTambem());
    }
}
