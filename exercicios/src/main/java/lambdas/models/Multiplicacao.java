package lambdas.models;

public class Multiplicacao implements Calculo {
    @Override
    public double executar(double a, double b) {
        return a * b;
    }
}
