package com.navas.campominado.models;

import com.navas.campominado.exceptions.ExplosaoException;

import java.util.ArrayList;
import java.util.List;

public class Campo {

    private final int linha;
    private final int coluna;
    private boolean minado = false;;
    private boolean aberto = false;
    private boolean marcado = false;

    private List<Campo> vizinhos = new ArrayList<>();

    Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    boolean adicionarVizinho(Campo vizinho) {
        boolean linhaDiferente = linha != vizinho.getLinha();
        boolean colunaDiferente = coluna != vizinho.getColuna();
        boolean diagonal = linhaDiferente && colunaDiferente;

        int deltaLinha = Math.abs(linha - vizinho.getLinha());
        int deltaColuna = Math.abs(coluna - vizinho.getColuna());
        int deltaGeral = deltaLinha + deltaColuna;

        if(!diagonal && deltaGeral == 1) {
            return vizinhos.add(vizinho);
        } else if(diagonal && deltaGeral == 2) {
            return vizinhos.add(vizinho);
        }

        return false;
    }

    void alternarMarcacao() {
        if(!aberto) {
            marcado = !marcado;
        }
    }

    boolean abrir() {
        if(!marcado && !aberto) {
            aberto = true;

            if(minado) {
                throw new ExplosaoException("você clicou num campo minado");
            }

            if(vizinhaSegura()) {
                vizinhos.forEach(Campo::abrir);
            }

            return true;
        }

        return false;
    }

    boolean vizinhaSegura() {
        return vizinhos.stream().noneMatch(vizinho -> vizinho.minado);
    }

    public int getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

    public boolean isMarcado() {
        return marcado;
    }
}
