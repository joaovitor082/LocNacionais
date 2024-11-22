package entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Cliente")
public class Cliente extends Usuario{
    private String cpf;
    private String endereco;
    private String telefone;
    private String nome;

    public Cliente() {
    }

    public Cliente(String login, String email, String senha, String cpf, String endereco,
            String telefone, String nome) {
        super(login, email, senha);
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
