package oo.heranca;

public class AtaqueTeste {
    public static void main(String[] args) {
        Jogador jogador = new Heroi();
        jogador.x = 0;
        jogador.y = 0;

        Jogador monstro = new Monstro();
        monstro.x = 0;
        monstro.y = 1;

        System.out.println(jogador.vida); // 100
        System.out.println(monstro.vida); // 100

        jogador.atacar(monstro);

        System.out.println(jogador.vida); // 100
        System.out.println(monstro.vida); // 95

        monstro.atacar(jogador);

        System.out.println(jogador.vida); // 80
        System.out.println(monstro.vida); // 95

        monstro.andar(Direcao.NORTE); // mudou a direção e deixou de ser paralelo

        boolean atacou = monstro.atacar(jogador);

        System.out.printf("atacou? %b\n", atacou);
        System.out.println(jogador.vida); // 80
        System.out.println(monstro.vida); // 95
    }
}
