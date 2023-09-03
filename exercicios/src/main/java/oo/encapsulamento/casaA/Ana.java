package oo.encapsulamento.casaA;

public class Ana {
    private String segredo = "segredo monaaa";
    String facoDentroDeCasa = "humm, o que será?";
    protected String formaDeFalar = "faço assim memo!";
    public String todosSabem = "todos sabem, mas ninguem faz";

    void acessos() {
        System.out.println(this.segredo); // somente a classe => mesmo pacote
        System.out.println(this.facoDentroDeCasa); // package (default) => mesmo pacote
        System.out.println(this.formaDeFalar); // protected => mesmo pacote e subclasses
        System.out.println(this.todosSabem); // public => mesmo pacote, subclasses e fora do pacote
    }
}
