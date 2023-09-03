package oo.heranca;

public class AtaqueTeste {
    public static void main(String[] args) {
        Jogador jogador = new Heroi();
        jogador.setX(0);
        jogador.setY(0);

        Jogador monstro = new Monstro(Jogador.MAXIMO_VIDA + 20);
        monstro.setX(0);
        monstro.setY(0);

        System.out.println(jogador.getVida());
        System.out.println(monstro.getVida());

        jogador.atacar(monstro);

        System.out.println(jogador.getVida());
        System.out.println(monstro.getVida());

        monstro.atacar(jogador);

        System.out.println(jogador.getVida());
        System.out.println(monstro.getVida());

        monstro.andar(Direcao.NORTE); // mudou a direção e deixou de ser paralelo

        boolean atacou = monstro.atacar(jogador);

        System.out.printf("atacou? %b\n", atacou);
        System.out.println(jogador.getVida());
        System.out.println(monstro.getVida());
    }
}
