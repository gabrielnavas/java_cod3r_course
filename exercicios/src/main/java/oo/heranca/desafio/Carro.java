package oo.heranca.desafio;

public abstract class Carro {

    protected static final double VELOCIDADE_MAXIMA = 80.0;
    protected static final double VELOCIDADE_MINIMA = 0.0;
    protected static final double RANGE_ACELERACAO = 5.0;

    private double velocidadeAtual;

    protected abstract boolean acelerar();

    protected abstract boolean freiar();

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }
}
