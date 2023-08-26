package fundamentos;

public class Aritmeticos {
    public static void main(String[] args) {
        int inFix = 2 + 3;

        int a = inFix - 4;
        int b = inFix * 4;
        int c = inFix / 4;
        int d = inFix % 2;

        int posFix = a++;
        int preFix = --a;

        System.out.println(inFix); // 5
        System.out.println(a); // 1
        System.out.println(b); // 20
        System.out.println(c); //  1
        System.out.println(d); //  1
        System.out.println(posFix); // 1
        System.out.println(preFix); // 1
    }
}
