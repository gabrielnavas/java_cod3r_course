package lambdas;

public class Consumer {
    public static void main(String[] args) {
        java.util.function.Consumer<String> b = x -> {
            System.out.printf("hello functional consumer %s.\n", x);
        };
        b.accept("yeah");
    }
}
