package oo.composicao.heranca;

public class AtaqueTeste {
    public static void main(String[] args) {
        Jogador jogador = new Heroi();
        jogador.x = 0;
        jogador.y = 0;

        Jogador oponente = new Heroi();
        oponente.x = 0;
        oponente.y = 1;

        System.out.println(jogador.vida);
        System.out.println(oponente.vida);

        jogador.atacar(oponente);

        System.out.println(jogador.vida);
        System.out.println(oponente.vida);
    }
}
