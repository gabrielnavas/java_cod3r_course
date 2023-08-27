package classe;

public class AreaCircTeste {
    public static void main(String[] args) {
        AreaCirc ac = new AreaCirc(5.6);
        System.out.println(ac.area());

        double area = AreaCirc.area(100);
        System.out.println(area);
        System.out.println(Math.PI);
    }
}
