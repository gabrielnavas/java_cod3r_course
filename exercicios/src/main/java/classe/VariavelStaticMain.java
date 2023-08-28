package classe;

public class VariavelStaticMain {

    int a = 3; // não pode mexer aqui
    public static void main(String[] args) {
        VariavelStaticMain pt = new VariavelStaticMain();
        System.out.println(pt.a);
    }
}
