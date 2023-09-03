package oo.heranca;

public class Jogador {
    int x;
    int y;

    int vida;

    final private static int MAXIMO_TABULEIRO = 100;
    final private static int MINIMO_TABULEIRO = 0;

    final public static int MAXIMO_VIDA = 100;

    final protected static int ATAQUE_PARALELO = 10;

    public Jogador(int vida) {
        this.vida = vida;
    }


    Jogador() {
        this.vida = MAXIMO_VIDA;
    }

    boolean atacar(Jogador oponente) {
        boolean atacou = false;

        int deltaX = Math.abs(x - oponente.x);
        int deltaY = Math.abs(y - oponente.y);

        // jogador e oponente está no mesmo eixo x e paralelos no eixo y
        if (deltaX == 0 && deltaY == 1) {
            reduzirVidaAtaqueParalelo(oponente);
            atacou = true;
        }

        // jogador e oponente está no mesmo eixo y e paralelos no eixo x
        else if (deltaY == 0 && deltaX == 1) {
            reduzirVidaAtaqueParalelo(oponente);
            atacou = true;
        }

        return atacou;
    }

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

    protected Jogador reduzirVidaAtaqueParalelo(Jogador oponente) {
        oponente.vida -= ATAQUE_PARALELO;
        return oponente;
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
