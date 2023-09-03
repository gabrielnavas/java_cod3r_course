package classe;

public class AreaCirc {

    private double raio;
    private final static double PI = 3.1415;

    public AreaCirc(double raio) {
        this.raio = raio;
    }

    public double area() {
        return AreaCirc.PI * Math.pow(raio, 2);
    }

    public static double area(double raio) {
        return AreaCirc.PI * Math.pow(raio, 2);
    }
}
