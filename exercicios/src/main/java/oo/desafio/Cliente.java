package oo.desafio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    final String nome;
    List<Compra> compras;

    Cliente(String nome) {
        this.nome = nome;
        compras = new ArrayList<>();
    }

    double obterGastoTotalLoja() {
        double total = 0.0;

        for (Compra compra : this.compras) {
            total += compra.obterGasto();
        }

        return total;
    }
}
