package oo.heranca.desafio;

public class Civic extends Carro {
    protected static final double VELOCIDADE_MAXIMA = Carro.VELOCIDADE_MAXIMA * 2 + 50;
    protected static final double RANGE_ACELERACAO = Carro.RANGE_ACELERACAO + 5;


    @Override
    protected boolean acelerar() {
        boolean acelerou = false;

        if (getVelocidadeAtual() + Civic.RANGE_ACELERACAO <= Civic.VELOCIDADE_MAXIMA) {
            setVelocidadeAtual(getVelocidadeAtual() + Civic.RANGE_ACELERACAO);
            acelerou = true;
        }

        return acelerou;
    }

    @Override
    protected boolean freiar() {
        boolean freiou = false;

        if (getVelocidadeAtual() - Civic.RANGE_ACELERACAO >= Civic.VELOCIDADE_MINIMA) {
            setVelocidadeAtual(getVelocidadeAtual() - Civic.RANGE_ACELERACAO);
            freiou = true;
        }

        return freiou;
    }
}
