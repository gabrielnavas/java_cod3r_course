package com.navas.campominado.exceptions;

public class CampoNaoEncontradoException extends RuntimeException {

    public CampoNaoEncontradoException(int linha, int coluna) {
        super(String.format(
                        "campo na posição linha %d e coluna %d não encontrado",
                        linha, coluna),
                new Exception(
                        String.format(
                                "campo na posição linha %d e coluna %d não encontrado",
                                linha, coluna)
                )
        );
    }
}
