package oo.composicao;

public class Carro {

    final Motor motor;

    Carro() {
        motor = new Motor(this);
    }

    void acelerar() {
        if (motor.fatorInjecao + 0.5 < 3) {
            motor.fatorInjecao += 0.5;
        }
    }

    void frear() {
        if (motor.fatorInjecao - 0.5 > 0.5) {
            motor.fatorInjecao -= 0.5;
        }
    }

    void ligar() {
        motor.ligado = true;
    }

    void desligar() {
        motor.ligado = false;
    }

    boolean estaLigado() {
        return motor.ligado;
    }
}
