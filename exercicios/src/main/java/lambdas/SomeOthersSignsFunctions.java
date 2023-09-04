package lambdas;

import java.util.function.*;

public class SomeOthersSignsFunctions {
    public static void main(String[] args) {
        Supplier<String> a = () -> "return something";
        System.out.println(a.get());

        Consumer<String> b = x -> {
            System.out.printf("hello functional consumer %s.\n", x);
        };
        b.accept("yeah");

        UnaryOperator<Double> c = x -> x;
        System.out.println(c.apply(42.42));

        BinaryOperator<String> d = (x, y) -> String.format("%s=%.2f", x, Double.valueOf(y));
        System.out.println(d.apply("Número", "44.1"));

        Function<Double, String> e = x -> String.format("%.2f", x);
        System.out.println(e.apply(10.22));

        Predicate<Double> f = x -> x > 10.0;
        System.out.println(f.test(10.1));

        IntBinaryOperator h = (x, y) -> x + y;
        System.out.println(h.applyAsInt(2, 4));
    }
}
