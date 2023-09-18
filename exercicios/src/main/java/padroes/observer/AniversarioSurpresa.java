package padroes.observer;

public class AniversarioSurpresa {
    public static void main(String[] args) {
        SubjectPorteiro porteiro = new SubjectPorteiro();

        porteiro.registrarObservador(evento -> System.out.printf("1º pessoa do evento. Evento iniciou as %s\n", evento));
        porteiro.registrarObservador(evento -> System.out.printf("2º pessoa do evento. Evento iniciou as %s\n", evento));
        porteiro.registrarObservador(evento -> System.out.printf("3º pessoa do evento. Evento iniciou as %s\n", evento));
        porteiro.registrarObservador(evento -> System.out.printf("4º pessoa do evento. Evento iniciou as %s\n", evento));

        porteiro.monitorar();
    }
}
