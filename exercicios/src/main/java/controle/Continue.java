package controle;

public class Continue {
    public static void main(String[] args) {
        int idade = 5;

        while (true) {
            if(idade == 9) {
                System.out.println("Você não precisa de festa!");
                idade++;
                continue;
            }

            System.out.printf("Parabens você fez o %d° aniversário\n", idade);

            if(idade == 10) {
                break;
            }
            idade++;
        }
    }
}
