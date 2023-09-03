package oo.heranca;

public class Monstro extends Jogador {

    static private int ATAQUE_PARALELO = Jogador.ATAQUE_PARALELO * 2;


    public Monstro(int vida) {
        super(vida);
    }

    @Override
    protected Jogador reduzirVidaAtaqueParalelo(Jogador oponente) {
        oponente.vida -= Monstro.ATAQUE_PARALELO;
        return oponente;
    }
}
