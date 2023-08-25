package fundamentos;

public class NotacaoPonto {
    public static void main(String[] args) {
        String s = "bom dia X";
        s = s.toUpperCase();
        s = s.replace("X", "Gabriel Navas");
        s = s.concat("!!!");

        System.out.println(s);
        System.out.println(s.length());
    }
}
