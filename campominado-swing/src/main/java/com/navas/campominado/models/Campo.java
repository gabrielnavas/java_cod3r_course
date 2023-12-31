package com.navas.campominado.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Campo {

    private final int linha;
    private final int coluna;
    private final Set<Campo> vizinhos = new HashSet<>();
    private final Set<CampoObservador> observadores = new HashSet<>();
    private boolean minado = false;
    private boolean aberto = false;
    private boolean marcado = false;

    Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public void registrarObservador(CampoObservador observador) {
        observadores.add(observador);
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

            notificarObservadores(marcado
                    ? CampoEvento.MARCAR
                    : CampoEvento.DESMARCAR
            );
        }
    }

    boolean abrir() {
        if (!aberto && !marcado) {

            if (minado) {
                notificarObservadores(CampoEvento.EXPLODIR);
                return true;
            }

            setAberto(true);

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

    private void notificarObservadores(CampoEvento evento) {
        observadores.stream().forEach(observador -> observador.eventoOcorreu(this, evento));
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
        if (aberto) {
            notificarObservadores(CampoEvento.ABRIR);
        }
    }
}
