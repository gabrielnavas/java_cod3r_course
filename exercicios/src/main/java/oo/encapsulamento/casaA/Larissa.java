package oo.encapsulamento.casaA;

public class Larissa extends Ana {

    @Override
    void acessos() {
        System.out.println(this.facoDentroDeCasa); // package (default) => mesmo pacote
        System.out.println(this.formaDeFalar); // protected => mesmo pacote e subclasses
        System.out.println(this.todosSabem); // public => mesmo pacote, subclasses e fora do pacote
    }
}
