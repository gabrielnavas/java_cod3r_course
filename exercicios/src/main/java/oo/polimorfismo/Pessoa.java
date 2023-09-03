package oo.polimorfismo;

public class Pessoa {
    private double peso;

    public Pessoa(double peso) {
        setPeso(peso);
    }


    // Polimorfismo dinâmico
    public void comer(Comida comida) {
        incrementarPeso(comida.getPeso());
    }

    private void incrementarPeso(double peso) {
        setPeso(getPeso() + peso);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso >= 0) {
            this.peso = peso;
        }
    }
}
