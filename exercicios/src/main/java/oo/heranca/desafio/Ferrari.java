package oo.heranca.desafio;

public class Ferrari extends Carro {

    protected static final double VELOCIDADE_MAXIMA = Ferrari.VELOCIDADE_MAXIMA * 3 + 60;
    protected static final double RANGE_ACELERACAO = Carro.RANGE_ACELERACAO * 3;

    @Override
    protected boolean acelerar() {
        boolean acelerou = false;

        if (velocidadeAtual + Ferrari.RANGE_ACELERACAO <= Ferrari.VELOCIDADE_MAXIMA) {
            velocidadeAtual += Ferrari.RANGE_ACELERACAO;
            acelerou = true;
        }

        return acelerou;
    }

    @Override
    protected boolean freiar() {
        boolean freiou = false;

        if (velocidadeAtual - Ferrari.RANGE_ACELERACAO >= Ferrari.VELOCIDADE_MINIMA) {
            velocidadeAtual -= Ferrari.RANGE_ACELERACAO;
            freiou = true;
        }

        return freiou;
    }
}
