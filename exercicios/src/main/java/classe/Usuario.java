package classe;

import java.util.Objects;

public class Usuario {
    String nome;
    String email;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Usuario)) {
            return false;
        }
        var u = (Usuario) obj;
        return nome.equals(u.nome) && email.equals(u.email);
    }

    // TODO: falta o hashcode
    @Override
    public int hashCode() {
        return 0;
    }
}
