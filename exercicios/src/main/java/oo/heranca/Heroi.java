package oo.heranca;

public class Heroi extends Jogador {
    static private int ATAQUE_PARALELO = Jogador.ATAQUE_PARALELO / 2;

    @Override
    protected Jogador reduzirVidaAtaqueParalelo(Jogador oponente) {
        oponente.setVida(oponente.getVida() - Heroi.ATAQUE_PARALELO);
        return oponente;
    }
}
