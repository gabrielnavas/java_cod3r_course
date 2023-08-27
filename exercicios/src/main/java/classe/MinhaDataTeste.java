package classe;

import java.util.Date;

public class MinhaDataTeste {
    public static void main(String[] args) {
        MinhaData md1 =new MinhaData(1, 12, 2008);
        md1.dia = 1;
        md1.mes = 12;
        md1.ano = 2008;

        MinhaData md2 =new MinhaData();
        md2.dia = 22;
        md2.mes = 6;
        md2.ano = 999;

        MinhaData md3 =new MinhaData();

        System.out.println(md1.obterDataFormatada(true));
        System.out.println(md1.obterDataFormatada(false));

        System.out.println(md2.obterDataFormatada(true));
        System.out.println(md2.obterDataFormatada(false));

        System.out.println(md3.obterDataFormatada(true));
        System.out.println(md3.obterDataFormatada(false));

    }
}
