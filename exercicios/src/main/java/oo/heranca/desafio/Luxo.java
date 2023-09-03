package oo.heranca.desafio;

public interface Luxo {
    void ligarAr();

    void desligarAr();

    default double velocidadeDoAr() {
        return 1.0;
    }
}
