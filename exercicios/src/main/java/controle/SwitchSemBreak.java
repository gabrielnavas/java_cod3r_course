package controle;

public class SwitchSemBreak {
    public static void main(String[] args) {
        String humor = "que isso?";

        switch (humor.toLowerCase()) {
            case "feliz":
                System.out.println("Parabéns");
            case "triste":
                System.out.println("Me diga o que houve?");
            case "neutro":
                System.out.println("Melhor que triste!");
            case "com fome":
                System.out.println("Vá comer!");
            default:
                System.out.println("Você nem tem humor");
        }
    }
}
