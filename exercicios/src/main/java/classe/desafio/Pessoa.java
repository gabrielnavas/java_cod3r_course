package classe.desafio;

public class Pessoa {

    String nome;
    double peso;

    Pessoa() {
        this("", 0.00);
    }
    Pessoa(String nome, double peso) {
        this.nome= nome;
        this.peso = peso;
    }

    void comer(Comida comida) {
        if(comida != null) {
            this.peso += comida.peso;
        }
    }
}
