package oo.encapsulamento.casaA;

public class Paulo {

    void acessos() {
        Ana esposa = new Ana();
        System.out.println(esposa.facoDentroDeCasa); // package (default) => mesmo pacote
        System.out.println(esposa.formaDeFalar); // protected => mesmo pacote e subclasses
        System.out.println(esposa.todosSabem); // public => mesmo pacote, subclasses e fora do pacote
    }
}
