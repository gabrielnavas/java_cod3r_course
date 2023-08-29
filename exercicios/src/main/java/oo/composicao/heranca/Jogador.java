package oo.composicao.heranca;

public class Jogador {
    int x;
    int y;

    final static int MAXIMO_TABULEIRO = 100;
    final static int MINIMO_TABULEIRO = 0;

    boolean andar(Direcao direcao) {
        boolean andou = false;

        if (isDirecaoNorte(direcao)) {
            y--;
            andou = true;
        } else if (isDirecaoLeste(direcao)) {
            x++;
            andou = true;
        } else if (isDirecaoSul(direcao)) {
            y++;
            andou = true;
        } else if (isDirecaoOeste(direcao)) {
            x--;
            andou = true;
        }

        return andou;
    }

    private boolean isDirecaoNorte(Direcao direcao) {
        return direcao == Direcao.NORTE && y - 1 >= MINIMO_TABULEIRO;
    }

    private boolean isDirecaoSul(Direcao direcao) {
        return direcao == Direcao.SUL && y + 1 <= MAXIMO_TABULEIRO;
    }

    private boolean isDirecaoLeste(Direcao direcao) {
        return direcao == Direcao.LESTE && x + 1 <= MAXIMO_TABULEIRO;
    }

    private boolean isDirecaoOeste(Direcao direcao) {
        return direcao == Direcao.OESTE && x - 1 >= MINIMO_TABULEIRO;
    }
}
