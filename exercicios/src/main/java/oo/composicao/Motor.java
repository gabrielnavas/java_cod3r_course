package oo.composicao;

public class Motor {

    private Carro carro;

    private boolean ligado;
    private double fatorInjecao;

    public Motor() {
        this.fatorInjecao = 1;
    }

    public Motor(Carro carro) {
        this();
        this.carro = carro;
    }

    int giros() {
        if (!ligado) {
            return 0;
        } else {
            return (int) Math.round(fatorInjecao * 3000);
        }
    }

    public Carro getCarro() {
        return carro;
    }

    public double getFatorInjecao() {
        return fatorInjecao;
    }

    public void setFatorInjecao(double fatorInjecao) {
        this.fatorInjecao = fatorInjecao;
    }

    public void setIsLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean isLigado() {
        return ligado;
    }
}
