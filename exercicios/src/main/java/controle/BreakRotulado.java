package controle;

public class BreakRotulado {
    public static void main(String[] args) {
        // é possível rotular os loops

        externo:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 1) {
                    break externo;
                }
                System.out.printf("i=%d j=%d\n", i, j);
            }
        }

        externo:
        for (int i = 0; i < 10; i++) {
            interno:
            for (int j = 0; j < 10; j++) {
                if (i == 1 && j == 3) {
                    break interno;
                }
                System.out.printf("i=%d j=%d\n", i, j);
            }
        }

        int i = 0;
        externo:
        while (i < 20) {
            int j = 0;
            interno:
            while (j < 10) {
                if(i == 0 && j == 9) {
                    j++;
                    continue interno;
                }
                if (i == 1 && j == 2) {
                    break externo;
                }
                System.out.printf("i=%d j=%d\n", i, j);
                j++;
            }
            i++;
        }
    }
}
