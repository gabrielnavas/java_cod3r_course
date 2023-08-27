package classe;

public class MinhaData {
    int dia;
    int mes;
    int ano;

    MinhaData() {
        dia = 1;
        mes = 1;
        ano = 1970;
    }

    MinhaData(int diaInicial, int mesInicial, int anoInicial) {
        dia = diaInicial;
        mes = mesInicial;
        ano = anoInicial;
    }

    String obterDataFormatada(boolean formatoAmericano) {
        String dataResultante;


        String diaFormatado;
        String mesFormatado;
        String anoFormatado;

        if (dia < 10) {
            diaFormatado = String.format("0%d", dia);
        } else {
            diaFormatado = String.format("%d", dia);
        }
        if (mes < 10) {
            mesFormatado = String.format("0%d", mes);
        } else {
            mesFormatado = String.format("%d", mes);
        }
        if (ano < 1000) {
            anoFormatado = String.format("0%d", ano);
        } else if (ano < 100) {
            anoFormatado = String.format("00%d", ano);
        } else if (ano < 10) {
            anoFormatado = String.format("000%d", ano);
        } else {
            anoFormatado = String.format("%d", ano);
        }

        if (formatoAmericano) {
            dataResultante = String.format("%s/%s/%s", mesFormatado, diaFormatado, anoFormatado);
        } else {
            dataResultante = String.format("%s/%s/%s", diaFormatado, mesFormatado, anoFormatado);
        }

        return dataResultante;
    }
}
