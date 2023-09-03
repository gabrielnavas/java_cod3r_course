package classe;

public class VariavelStaticMain {

    private int a = 3; // não pode mexer aqui, variável intância

    public static void main(String[] args) {
        VariavelStaticMain pt = new VariavelStaticMain();
        System.out.println(pt.a);
    }
}
