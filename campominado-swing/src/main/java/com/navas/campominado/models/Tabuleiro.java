package com.navas.campominado.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Tabuleiro implements CampoObservador {

    // TODO: implementar usando matrix => List<List<Campo>> campos = new ArrayList<>();
    private final List<Campo> campos;
    private final List<Consumer<ResultadoEvento>> observadores = new ArrayList<>();
    private int linhas;
    private int colunas;
    private int minas;

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;
        this.campos = new ArrayList<>();

        gerarCampos();
        associarOsVizinhos();
        sortearMinas();
    }

    public void paraCadaCampo(Consumer<Campo> funcao) {
        campos.forEach(funcao);
    }

    public void registrarObservador(Consumer<ResultadoEvento> observador) {
        observadores.add(observador);
    }

    public void notificarObservadores(boolean resultado) {
        observadores.forEach(observador -> observador.accept(new ResultadoEvento(resultado)));
    }

    public void abrirCampo(int linha, int coluna) {
        campos.parallelStream()
                .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                .findFirst()
                .ifPresent(Campo::abrir);
    }

    public void alterarMarcacaoCampo(int linha, int coluna) {
        if (linha >= linhas || coluna >= colunas || linha < 0 || coluna < 0) {
            // TODO: implementar lançamento de exception ou tratar isso
        }
        campos.parallelStream()
                .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                .findFirst()
                .ifPresent(Campo::alternarMarcacao);
    }

    private void gerarCampos() {
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                Campo campo = new Campo(linha, coluna);
                campo.registrarObservador(this);
                campos.add(campo);
            }
        }
    }

    private void associarOsVizinhos() {
        for (Campo c1 : campos) {
            for (Campo c2 : campos) {
                c1.adicionarVizinho(c2);
            }
        }
    }

    private void sortearMinas() {
        long minasArmadas = 0;
        Predicate<Campo> minado = Campo::isMinado;

        do {
            int aleatorio = (int) (Math.random() * campos.size());
            campos.get(aleatorio).minar();
            minasArmadas = campos.stream().filter(minado).count();
        } while (minasArmadas < minas);
    }

    public Campo[][] getCampos() {
        Campo[][] campos = new Campo[linhas][colunas];
        IntStream.range(0, linhas).forEach(linha ->
                IntStream.range(0, colunas).forEach(coluna -> {
                    Optional<Campo> campo = this.campos
                            .stream()
                            .filter(campoN -> campoN.getLinha() == linha
                                    && campoN.getColuna() == coluna
                            ).findFirst();
                    campo.ifPresent(value -> campos[linha][coluna] = value);
                }));
        return campos;
    }

    public boolean objetivoAlcando() {
        return campos.stream().allMatch(Campo::objetivoAlcancado);
    }

    public void reiniciar() {
        campos.forEach(Campo::reiniciar);
        sortearMinas();
    }

    public int getColunas() {
        return colunas;
    }

    public int getLinhas() {
        return linhas;
    }

    @Override
    public void eventoOcorreu(Campo campo, CampoEvento campoEvento) {
        if (campoEvento == CampoEvento.EXPLODIR) {
            mostrarMinas();
            notificarObservadores(false);
        } else if (objetivoAlcando()) {
            notificarObservadores(true);
        }
    }

    private void mostrarMinas() {
        campos.stream()
                .filter(Campo::isMinado)
                .forEach(campo -> campo.setAberto(true));
    }
}
