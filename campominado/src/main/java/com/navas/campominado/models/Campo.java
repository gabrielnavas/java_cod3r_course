package com.navas.campominado.models;

import com.navas.campominado.exceptions.ExplosaoException;

import java.util.ArrayList;
import java.util.List;

public class Campo {

    private final int linha;
    private final int coluna;
    private final List<Campo> vizinhos = new ArrayList<>();
    private boolean minado = false;
    private boolean aberto = false;
    private boolean marcado = false;

    Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    boolean adicionarVizinho(Campo vizinho) {
        boolean linhaDiferente = linha != vizinho.linha;
        boolean colunaDiferente = coluna != vizinho.coluna;
        boolean diagonal = linhaDiferente && colunaDiferente;

        int deltaLinha = Math.abs(linha - vizinho.linha);
        int deltaColuna = Math.abs(coluna - vizinho.coluna);
        int detalGeral = deltaColuna + deltaLinha;

        if (detalGeral == 1 && !diagonal) {
            vizinhos.add(vizinho);
            return true;
        } else if (detalGeral == 2 && diagonal) {
            vizinhos.add(vizinho);
            return true;
        } else {
            return false;
        }
    }

    void alternarMarcacao() {
        if (!aberto) {
            marcado = !marcado;
        }
    }

    boolean abrir() {
        if (!aberto && !marcado) {
            aberto = true;

            if (minado) {
                throw new ExplosaoException("você clicou num campo minado");
            }

            if (vizinhacaSegura()) {
                vizinhos.forEach(Campo::abrir);
            }

            return true;
        } else {
            return false;
        }
    }

    boolean vizinhacaSegura() {
        return vizinhos.stream().noneMatch(Campo::isMinado);
    }

    void minar() {
        if (!aberto) {
            minado = true;
        }
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

    public boolean isMinado() {
        return minado;
    }

    public boolean isAberto() {
        return aberto;
    }

    void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public List<Campo> getVizinhos() {
        return vizinhos.stream().toList();
    }

    boolean objetivoAlcancado() {
        boolean desvendado = !minado && aberto;
        boolean protegido = minado && marcado;
        return desvendado || protegido;
    }

    long minasNaVizinhaca() {
        return vizinhos.stream().filter(v -> v.minado).count();
    }

    void reiniciar() {
        minado = false;
        aberto = false;
        marcado = false;
    }

    @Override
    public String toString() {
        if (marcado) {
            return "x";
        } else if (aberto && minado) {
            return "*";
        } else if (aberto && minasNaVizinhaca() > 0) {
            return Long.toString(minasNaVizinhaca());
        } else if (aberto) {
            return " ";
        } else {
            return "?";
        }
    }
}
