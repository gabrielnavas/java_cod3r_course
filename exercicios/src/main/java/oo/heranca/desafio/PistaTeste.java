package oo.heranca.desafio;

public class PistaTeste {
    public static void main(String[] args) {
        Carro civic = new Civic();
        Ferrari ferrari = new Ferrari(1);

        civic.acelerar();
        ferrari.acelerar();

        System.out.printf("Velocidade do Civic %.2fKM/h\n", civic.getVelocidadeAtual());
        System.out.printf("Velocidade da Ferrari %.2fKM/h\n", ferrari.getVelocidadeAtual());

        ferrari.ligarTurbo();
        System.out.println(ferrari.acelerar());

        System.out.printf("Velocidade do Civic %.2fKM/h\n", civic.getVelocidadeAtual());
        System.out.printf("Velocidade da Ferrari %.2fKM/h\n", ferrari.getVelocidadeAtual());

    }
}
