package classe;

public class Usuario {
    private String nome;
    private String email;

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


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
