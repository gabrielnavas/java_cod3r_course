package fundamentos;

public class ConversaoTipoPrimitivoNumerico {
    public static void main(String[] args) {

        // conversão implícita
        double a = 1;
        System.out.println(a);

        // conversão explícita (cast)
        float b = (float) 1.0;
        System.out.println(b);

        // outro exemplo truncado decast de double para byte
        double c = 127.233444;
        byte d = (byte) c;
        System.out.println(d); // 127
    }
}
