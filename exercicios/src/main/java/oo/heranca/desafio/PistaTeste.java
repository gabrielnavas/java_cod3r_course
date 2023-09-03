package oo.heranca.desafio;

public class PistaTeste {
    public static void main(String[] args) {
        Carro civic = new Civic();
        Ferrari ferrari = new Ferrari(1);

        System.out.printf("Civic acelerou? %b\n", civic.acelerar());
        System.out.printf("Ferrari acelerou? %b\n", ferrari.acelerar());

        System.out.printf("Velocidade do Civic %.2fKM/h\n", civic.getVelocidadeAtual());
        System.out.printf("Velocidade da Ferrari %.2fKM/h\n", ferrari.getVelocidadeAtual());

        ferrari.ligarTurbo();
        ferrari.ligarAr();
        System.out.printf("Ferrari acelerou? %b\n", ferrari.acelerar());

        System.out.printf("Velocidade do Civic %.2fKM/h\n", civic.getVelocidadeAtual());
        System.out.printf("Velocidade da Ferrari %.2fKM/h\n", ferrari.getVelocidadeAtual());

    }
}
