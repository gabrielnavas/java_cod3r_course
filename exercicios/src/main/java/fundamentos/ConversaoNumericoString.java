package fundamentos;

public class ConversaoNumericoString {
    public static void main(String[] args) {
        // instancia de integer para string
        Integer num1 = 1000;
        String mil = num1.toString();
        System.out.println(mil);

        // int primitivo para string
        int num2 = 2000;
        String doisMill = Integer.toString(num2);
        System.out.println(doisMill);

        // outros tipos de to string
        Double.toString(1000.00);
        Short.toString((short) 10);
        // entre outros
    }
}
