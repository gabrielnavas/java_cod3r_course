package com.navas.campominado.models;

@FunctionalInterface
public interface CampoObservador {

    void eventoOcorreu(Campo campo, CampoEvento campoEvento);
}
