package fundamentos;

public class TiposPrimitivos {
    public static void main(String[] args) {

        // Tipos numéricos inteiros
        byte bMin = -128;
        byte bMax = 127;

        short sMin = -32_768;
        short sMax = 32_767;

        int iMin = Integer.MIN_VALUE;
        int iMax = Integer.MAX_VALUE;
        int iQualquer = 42;

        long lMin = Long.MIN_VALUE;
        long lMax = Long.MAX_VALUE;
        long lQualquer = 1_123_321_123;


        // Tipos numéricos reais
        float fMin = Float.MIN_VALUE;
        float fMax = Float.MAX_VALUE;
        float fQualquer = 24_444.11F;
        float fDeInt = 24;

        double dMin = Double.MIN_VALUE;
        double dMax = Double.MAX_VALUE;
        double dQualquer = 21.44;
        double dDeFloat = 21.44f;
        double dDeInt = 21;

        // Tipo caracteree
        char cMin = Character.MAX_VALUE;
        char cMax = Character.MIN_VALUE;
        char cUnicode = '\u0010';
        char cLetra = 'a';
        char cDeInt = 9999;

        // Tipo booleano
        boolean bVerdade = true;
        boolean bFalso = false;
    }
}
