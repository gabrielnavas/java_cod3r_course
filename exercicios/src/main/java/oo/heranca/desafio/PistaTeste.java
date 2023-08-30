package oo.heranca.desafio;

public class PistaTeste {
    public static void main(String[] args) {
        Carro civic = new Civic();
        Carro ferrari = new Ferrari();

        civic.acelerar();
        civic.acelerar();
        civic.freiar();

        ferrari.acelerar();
        ferrari.acelerar();
        ferrari.freiar();

        System.out.printf("Velocidade do Civic %.2fKM/h\n", civic.velocidadeAtual);
        System.out.printf("Velocidade da Ferrari %.2fKM/h\n", ferrari.velocidadeAtual);
    }
}
