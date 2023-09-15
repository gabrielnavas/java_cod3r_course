package excecao.exemplos;

public class ChecadaVsNaoChecada {
    public static void main(String[] args) {

        // quando lançado uma exception checada, é necessário tratar
        try {
            gerarException();
        } catch (Exception e) {
            System.out.println("houve uma exception genérica");
        }

        // exceptions ou errors não checados não precisam ser tratados.
        gerarRunetimeException();
        gerarOutOfMemoryError();
        gerarError();

        try {
            gerarRunetimeException();
            gerarOutOfMemoryError();
            gerarError();
        }
        catch (RuntimeException ex) {
            System.out.println("houve uma exception do tipo Exception");
        }
        catch (OutOfMemoryError ex) {
            System.out.println("houve um error do tipo OutOfMemoryError");
        }
        catch (VirtualMachineError ex) {
            System.out.println("houve um error do tipo VirtualMachineError");
        }
        catch (Error ex) {
            System.out.println("houve um error do tipo Error");
        }
    }

    // é preciso deixar claro que tem uma exception checada.
    static void gerarException() throws Exception {
        throw new Exception("Ocorreu um error bem legal #01!");
    }

    static void gerarRunetimeException() {
        throw new RuntimeException("Ocorreu um error bem legal #01!");
    }

    static void gerarOutOfMemoryError() {
        throw new OutOfMemoryError("Ocorreu um error bem legal #01!");
    }

    static void gerarError() {
        throw new Error("Ocorreu um error bem legal #01!");
    }

}
