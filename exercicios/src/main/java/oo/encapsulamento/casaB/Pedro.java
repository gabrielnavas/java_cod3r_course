package oo.encapsulamento.casaB;

import oo.encapsulamento.casaA.Ana;

public class Pedro {
    void acessos() {
        Ana prima = new Ana();
        System.out.println(prima.todosSabem); // public => mesmo pacote, subclasses e fora do pacote
    }
}
