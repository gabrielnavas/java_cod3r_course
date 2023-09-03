package classe.desafio;

public class Jantar {
    public static void main(String[] args) {
        Comida feijao = new Comida("Feijão", 0.223);
        Comida arroz = new Comida("Arroz", 0.198);
        Pessoa pessoa = new Pessoa("João", 85.00);

        System.out.printf("O peso do %s antes de comer: %.2fkg\n", pessoa.getNome(), pessoa.getPeso());

        pessoa.comer(feijao);
        pessoa.comer(arroz);

        System.out.printf("O peso do %s depois de comer: %.2fkg\n", pessoa.getNome(), pessoa.getPeso());
    }
}
