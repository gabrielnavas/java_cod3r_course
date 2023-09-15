package excecao;

public class NumeroNegativoException extends Exception {

    public NumeroNegativoException(String message) {
        super(message, new Exception(message));
    }

    public NumeroNegativoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumeroNegativoException(Throwable cause) {
        super(cause.getMessage(), cause);
    }
}
