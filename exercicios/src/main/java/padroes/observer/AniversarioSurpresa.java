package padroes.observer;

public class AniversarioSurpresa {
    public static void main(String[] args) {
        SubjectPorteiro porteiro = new SubjectPorteiro();

        porteiro.registrarObservador(evento -> {
            System.out.printf("evento iniciou as %s", evento);
        });

        porteiro.monitorar();
    }
}
