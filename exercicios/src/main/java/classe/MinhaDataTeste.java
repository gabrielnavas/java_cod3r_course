package classe;

public class MinhaDataTeste {
    public static void main(String[] args) {
        MinhaData md1 = new MinhaData(1, 12, 2008);
        md1.setDia(1);
        md1.setMes(1);
        md1.setAno(2008);

        MinhaData md2 = new MinhaData();

        md2.setDia(22);
        md2.setMes(6);
        md2.setAno(999);

        MinhaData md3 = new MinhaData();

        System.out.println(md1.obterDataFormatada(true));
        System.out.println(md1.obterDataFormatada(false));

        System.out.println(md2.obterDataFormatada(true));
        System.out.println(md2.obterDataFormatada(false));

        System.out.println(md3.obterDataFormatada(true));
        System.out.println(md3.obterDataFormatada(false));

    }
}
