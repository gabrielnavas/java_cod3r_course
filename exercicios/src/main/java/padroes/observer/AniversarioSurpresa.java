package padroes.observer;

public class AniversarioSurpresa {
    public static void main(String[] args) {
        Namorada namorada = new Namorada("Júlia");

        SubjectPorteiro porteiro = new SubjectPorteiro();
        porteiro.registrarObservador(namorada);

        porteiro.monitorar();
    }
}
