package oo.composicao;

public class CarroTest {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.ligar();
        System.out.println(carro.estaLigado());
        System.out.println(carro.getMotor().giros());

        for (int i = 0; i < 5; i++) {
            carro.acelerar();
        }

        System.out.println(carro.getMotor().giros());

        for (int i = 0; i < 100; i++) {
            carro.frear();
        }

        System.out.println(carro.getMotor().giros());

        // haha, relacionamento bidirecional
        System.out.println(carro.getMotor().getCarro().getMotor().getCarro().getMotor().getCarro().getMotor().giros());
    }
}
