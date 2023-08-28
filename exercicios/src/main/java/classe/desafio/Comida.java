package classe.desafio;

public class Comida {

    String nome;
    double peso;

    Comida() {
        this("", 0.00);
    }
    Comida(String nome, double peso) {
        this.nome= nome;
        this.peso = peso;
    }
}
