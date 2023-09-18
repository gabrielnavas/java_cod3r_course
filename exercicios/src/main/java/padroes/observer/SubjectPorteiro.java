package padroes.observer;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubjectPorteiro {

    private Set<ObserverChegadaAniversariante> observadores;

    public SubjectPorteiro() {
        this.observadores = new HashSet<>();
    }

    public void registrarObservador(ObserverChegadaAniversariante observer) {
        observadores.add(observer);
    }

    public void monitorar() {
        Scanner entrada = new Scanner(System.in);

        String valor = "";

        while(!"sair".equalsIgnoreCase(valor)) {

            System.out.println("Aniversariante chegou? ");
            valor = entrada.nextLine();

            if("sim".equalsIgnoreCase(valor)) {
                EventoChegadaAniversariante evento = new EventoChegadaAniversariante(new Date());

                // notificar os observadores;
                observadores.forEach(observer -> observer.chegou(evento));
                observadores.removeAll(observadores);
                valor = "sair";
            } else {
                System.out.println("Alarme falso!!");
            }
        }
    }

}
