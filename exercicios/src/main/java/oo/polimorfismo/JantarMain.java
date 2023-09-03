package oo.polimorfismo;

public class JantarMain {
    public static void main(String[] args) {
        Pessoa convidadoJoao = new Pessoa(99.65);

        Arroz ingrediente1 = new Arroz(0.25);
        Feijao ingrediente2 = new Feijao(0.25);
        Sorvete ingrediente3 = new Sorvete(0.25);

        System.out.println(convidadoJoao.getPeso()); // 99.65

        convidadoJoao.comer(ingrediente1);
        convidadoJoao.comer(ingrediente2);
        convidadoJoao.comer(ingrediente3);

        System.out.println(convidadoJoao.getPeso()); // 100.4
    }
}
