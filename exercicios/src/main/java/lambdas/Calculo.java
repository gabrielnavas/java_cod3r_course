package lambdas;

@FunctionalInterface
public interface Calculo {
    double executar(double a, double b);

    default String metodoComImplementacaoPode() {
        return "massa!";
    }

    static String metodoStaticPodeTambem() {
        return "sou estatico";
    }
}
