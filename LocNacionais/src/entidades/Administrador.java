package entidades;

public class Administrador {
    private String nome;
    private int senha;

    public Administrador(String nome, int senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
      return nome;
    }

    public int getSenha() {
      return senha;
    }
}
