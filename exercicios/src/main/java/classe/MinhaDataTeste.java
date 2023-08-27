package classe;

import java.util.Date;

public class MinhaDataTeste {
    public static void main(String[] args) {
        MinhaData md1 =new MinhaData();
        md1.dia = 25;
        md1.mes = 12;
        md1.ano = 2008;

        MinhaData md2 =new MinhaData();
        md2.dia = 22;
        md2.mes = 06;
        md2.ano = 1999;

        System.out.printf("%s/%s/%s\n", md1.dia, md1.mes, md1.ano);
        System.out.printf("%s/%s/%s\n", md2.dia, md2.mes, md2.ano);
    }
}
