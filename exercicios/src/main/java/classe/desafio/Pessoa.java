package classe.desafio;

public class Pessoa {

    private String nome;
    private double peso;

    public Pessoa() {
        this("", 0.00);
    }

    public Pessoa(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public void comer(Comida comida) {
        if (comida != null) {
            this.peso += comida.getPeso();
        }
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }
}
