package fundamentos;

public class PrimitivoVsObjeto {
    public static void main(String[] args) {
        String s = "texto";
        s = s.toUpperCase();

        // Wrappers são a versão objetos dos tipos primitivos
        int a = 123;
        System.out.println(a);
    }
}
