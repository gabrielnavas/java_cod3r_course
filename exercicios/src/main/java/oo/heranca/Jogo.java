package oo.heranca;

public class Jogo {
    public static void main(String[] args) {
        Jogador jogador = new Jogador();

        jogador.andar(Direcao.NORTE); // x=0, y=-1
        jogador.andar(Direcao.LESTE); // x=1, y=0
        jogador.andar(Direcao.SUL); // x=1, y=1
        jogador.andar(Direcao.OESTE); // x=0, y=1

        System.out.printf("x=%d, y=%d", jogador.getX(), jogador.getY()); // x=0, y=1
    }
}
