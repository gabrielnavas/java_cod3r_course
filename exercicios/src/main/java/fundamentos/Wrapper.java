package fundamentos;

public class Wrapper {
    public static void main(String[] args) {

        // inteiros
        Byte b = 100;
        Short s = 1000;
        Integer i = 10000;
        Integer i2 = Integer.parseInt("10000");
        Long l = 100000L;

        System.out.println(b.byteValue());
        System.out.println(i2);
        System.out.println(l / 3);

        // ponto flutuante
        Float f = 123.0F;
        Double d = 123.44;
        System.out.println(f);
        System.out.println(d);


        // boolean
        Boolean bo = Boolean.parseBoolean("true");
        System.out.println(bo); // true
        System.out.println(bo.equals(true)); // true

        // caractere
        Character c = '#';
        System.out.println(c); // #

    }
}
