package fundamentos.operadores;

public class Logicos {
    public static void main(String[] args) {

        // e (AND)
        boolean e1 = false & false; // false
        boolean e2 = true & false; // true
        boolean e3 = true & true; // true
        boolean e4 = true & true; // true

        // ou (OR)
        boolean ou1 = false || false; // false
        boolean ou2 = true || false; // true
        boolean ou3 = false || true; // true
        boolean ou4 = true || true; // true

        // ou exclusivo (XOR)
        boolean ouEx1 = false ^ false;  // false
        boolean ouEx2 = false ^ true;  // true
        boolean ouEx3 = true ^ false;  // true
        boolean ouEx4 = true ^ true;  // false

        // negações (NOT)
        boolean not1 = !true; // false
        boolean not2 = !false; // true
        boolean not3 = !!false; // false
        boolean not4 = !!true; // true
    }
}
