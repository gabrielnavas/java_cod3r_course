package fundamentos;

public class TipoString {

    public static void main(String[] args) {

        // pegar um caractere
        String nome = "Gabriel Navas";
        char letraG = nome.charAt(0);
        System.out.println(letraG);

        // string é imutável
        String sobrenome = "Silva";
//        sobrenome[0] = "s";

        // string mutável
        StringBuilder exemploString = new StringBuilder("Me mude");
        exemploString.setCharAt(1, '&');
        System.out.println(exemploString);

        // verificando se é igual ignorando o case
        String nome1 = "JOAO";
        String nome2 = "joao";
        System.out.println(nome1.equalsIgnoreCase(nome2)); // true

        // inferência de tipo string
        var pedro = "pedro";
        System.out.println(pedro.getClass()); // class java.lang.String

        // gerando uma string custom com outros valores
        String nomeFormatado = String.format("%s %s %s", "Gabriel", "Silva", "Meira");
        System.out.println(nomeFormatado);

        // verifica se uma string está na outra
        String rua1 = "Rua das Galinhas Azuis";
        String rua2 = "Rua das Galinhas Rosas";
        System.out.println(rua1.contains("azuis")); // true

        // pegar index que comeca uma string
        String produto1 = "Apple TV 2022";
        int indexTV2022 = produto1.indexOf("TV 2022");
        System.out.println(indexTV2022); // 6

        // pegar uma substring
        String produto2 = "Mouse Vertical Logitech R$500,00";
        String tipoProduto = produto2.substring(0, 5); // range 15-23, o 24 ele não pega
        System.out.println(tipoProduto); // tipo produto

    }
}
