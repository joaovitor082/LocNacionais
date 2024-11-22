package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Administrador")
public class Administrador extends Usuario {
    private String cargo;

    public Administrador() {
    }

    public Administrador(String login, String email, String senha) {
        super(login, email, senha);
        this.cargo = "Administrador";
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
