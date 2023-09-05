package lambdas;

import java.util.function.Function;

public class Functions {
    public static void main(String[] args) {
        Function<Double, String> e = x -> String.format("%.2f", x);
        System.out.println(e.apply(10.22));
    }
}
