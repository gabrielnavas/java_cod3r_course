package classe;

public class ValorVsReferencia {
    public static void main(String[] args) {
        double a = 2;
        double b = a; // atribuição por valor

        a++;
        b--;

        System.out.printf("a=%f b=%f\n", a, b);

        MinhaData d1 = new MinhaData(1, 6, 2022);
        MinhaData d2 = d1; // atribuição por referência (Objeto)

        d1.setDia(31);
        d2.setMes(12);

        System.out.println(d1.obterDataFormatada(false));
        System.out.println(d2.obterDataFormatada(false));

        voltarDataParaValorPadrao(d2);

        System.out.println(d1.obterDataFormatada(false));
        System.out.println(d2.obterDataFormatada(false));

        int c = 5;
        System.out.println(c);
        alterarPrimitivo(c);
        System.out.println(c);
    }

    static void voltarDataParaValorPadrao(MinhaData d) {
        d.setDia(1);
        d.setMes(1);
        d.setAno(1970);
    }

    static void alterarPrimitivo(int a) {
        a++;
    }
}
