package oo.heranca.desafio;

public class Ferrari extends Carro implements Esportivo, Luxo {

    protected static final double VELOCIDADE_MAXIMA = Ferrari.VELOCIDADE_MAXIMA * 3 + 60;
    protected static final double RANGE_ACELERACAO = Carro.RANGE_ACELERACAO * 3;

    private double delta;

    private double velocidadeArCondicionado;

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

    @Override
    public void ligarTurbo() {
        delta *= 2;
    }

    @Override
    public void desligarTurbo() {
        delta /= 2;
    }

    @Override
    public double velocidadeDoAr() {
        return velocidadeArCondicionado;
    }

    @Override
    public void ligarAr() {
        setVelocidadeAtual(20.0);
    }

    @Override
    public void desligarAr() {
        setVelocidadeAtual(0.00);
    }

    @Override
    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeArCondicionado = velocidadeAtual;
    }

    @Override
    public double getVelocidadeAtual() {
        return this.velocidadeArCondicionado;
    }
}
