package fundamentos;

public class DesafioAritmeticos {
    public static void main(String[] args) {
        double p1 = ((Math.pow((6 * (3 + 2)), 2)) / (3 * 2));
        double p2 = Math.pow((double) ((1 - 5) * (2 - 7)) / 2, 2);
        double up = Math.pow((p1 - p2), 3);
        double down = Math.pow(10, 3);
        double result = up / down;
        System.out.println(result);
    }
}
