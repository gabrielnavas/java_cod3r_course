package lambdas;

import lambdas.models.Calculo;
import lambdas.models.Multiplicacao;
import lambdas.models.Soma;

public class CalculoTesteOO {
    public static void main(String[] args) {
        Calculo calculo = new Soma();
        System.out.println(calculo.executar(2, 3));

        calculo = new Multiplicacao();
        System.out.println(calculo.executar(2, 3));
    }
}
