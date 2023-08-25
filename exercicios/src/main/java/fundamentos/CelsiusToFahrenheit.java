package fundamentos;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        final double cel = 40.0;
        final double fator = 1.8;

        // to fahrenheit
        final int ajuste = 32;
        final double fah = (cel * fator) + ajuste;

        System.out.printf("Celsious to fahrenheit = %.2f°F\n", fah); // Celsious to Fahrenheit = 104.00F
    }
}
