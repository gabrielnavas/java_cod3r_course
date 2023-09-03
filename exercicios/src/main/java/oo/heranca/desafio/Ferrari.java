package oo.heranca.desafio;

public class Ferrari extends Carro implements Esportivo {

    protected static final double VELOCIDADE_MAXIMA = Ferrari.VELOCIDADE_MAXIMA * 3 + 60;
    protected static final double RANGE_ACELERACAO = Carro.RANGE_ACELERACAO * 3;

    private double delta;

    public Ferrari(double delta) {
        super();
        this.delta = delta;
    }

    @Override
    protected boolean acelerar() {
        boolean acelerou = false;

        double calculoDelta = delta * Ferrari.RANGE_ACELERACAO;
        double velocidade = getVelocidadeAtual() + calculoDelta;
        if (velocidade <= Ferrari.VELOCIDADE_MAXIMA) {
            setVelocidadeAtual(velocidade);
            acelerou = true;
        }

        return acelerou;
    }

    @Override
    protected boolean freiar() {
        boolean freiou = false;

        double calculoDelta = delta * Ferrari.RANGE_ACELERACAO;
        double velocidade = getVelocidadeAtual() - calculoDelta;
        if (velocidade >= Ferrari.VELOCIDADE_MINIMA) {
            setVelocidadeAtual(velocidade);
            freiou = true;
        }

        return freiou;
    }

    public void ligarTurbo() {
        delta *= 2;
    }

    public void desligarTurbo() {
        delta /= 2;
    }
}
