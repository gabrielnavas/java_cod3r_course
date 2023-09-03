package oo.heranca.desafio;

public class Carro {

    protected static final double VELOCIDADE_MAXIMA = 80.0;
    protected static final double VELOCIDADE_MINIMA = 0.0;
    protected static final double RANGE_ACELERACAO = 5.0;

    private double velocidadeAtual;

    protected boolean acelerar() {
        boolean acelerou = false;

        if (velocidadeAtual + Carro.RANGE_ACELERACAO <= Carro.VELOCIDADE_MAXIMA) {
            velocidadeAtual += Carro.RANGE_ACELERACAO;
            acelerou = true;
        }

        return acelerou;
    }

    protected boolean freiar() {
        boolean freiou = false;

        if (velocidadeAtual - Carro.RANGE_ACELERACAO >= Carro.VELOCIDADE_MINIMA) {
            velocidadeAtual -= Carro.RANGE_ACELERACAO;
            freiou = true;
        }

        return freiou;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }
}
