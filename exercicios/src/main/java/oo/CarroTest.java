package oo;

public class CarroTest {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.ligar();
        System.out.println(carro.estaLigado());
        System.out.println(carro.motor.giros());

        for (int i = 0; i < 5; i++) {
            carro.acelerar();
        }

        System.out.println(carro.motor.giros());

        for (int i = 0; i < 100; i++) {
            carro.frear();
        }

        System.out.println(carro.motor.giros());

        // haha, relacionamento bidirecional
        System.out.println(carro.motor.carro.motor.carro.motor.carro.motor.giros());
    }
}
