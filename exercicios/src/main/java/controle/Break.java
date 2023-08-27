package controle;

public class Break {
    public static void main(String[] args) {
        int idade = 5;

        while (true) {
            System.out.printf("Parabens você fez o %d° aniversário\n", idade);
            if(idade == 10) {
                break;
            }
            idade++;
        }
    }
}
