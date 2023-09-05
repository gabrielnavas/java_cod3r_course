package lambdas;

import java.util.function.Supplier;

public class Suppliers {
    public static void main(String[] args) {
        Supplier<String> a = () -> "return something";
        System.out.println(a.get());
    }
}
