package classe;

public class AreaCirc {

    double raio;
    final static double PI = 3.1415;

    AreaCirc(double raio) {
        this.raio = raio;
    }

    double area() {
        return AreaCirc.PI * Math.pow(raio, 2);
    }

    static double area(double raio) {
        return AreaCirc.PI * Math.pow(raio, 2);
    }
}
