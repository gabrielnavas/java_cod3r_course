package oo.composicao;

public class Carro {

    private final Motor motor;

    public Carro() {
        motor = new Motor(this);
    }

    void acelerar() {
        if (motor.getFatorInjecao() + 0.5 < 3) {
            motor.setFatorInjecao(motor.getFatorInjecao() + 0.5);
        }
    }

    void frear() {
        if (motor.getFatorInjecao() - 0.5 > 0.5) {
            motor.setFatorInjecao(motor.getFatorInjecao() - 0.5);
        }
    }

    void ligar() {
        motor.setIsLigado(true);
    }

    void desligar() {
        motor.setIsLigado(false);
    }

    boolean estaLigado() {
        return motor.isLigado();
    }

    public Motor getMotor() {
        return motor;
    }
}
