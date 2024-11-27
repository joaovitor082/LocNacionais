package service;

import repositories.UsuarioRepository;
import entities.Usuario;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    // Busca um usuário pelo ID
    public Usuario buscarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        return usuarioRepository.buscarPorId(id);
    }

    // Verifica se o login é válido com base no email e senha
    public boolean checarLogin(String email, String senha) {
        if (email == null || senha == null || email.isEmpty() || senha.isEmpty()) {
            throw new IllegalArgumentException("Email e senha não podem ser nulos ou vazios.");
        }
        return usuarioRepository.checarLogin(email, senha);
    }

    // Busca um usuário com base no email e senha
    public Usuario buscarUsuario(String email, String senha) {
        if (email == null || senha == null || email.isEmpty() || senha.isEmpty()) {
            throw new IllegalArgumentException("Email e senha não podem ser nulos ou vazios.");
        }
        Usuario usuario = usuarioRepository.buscarUsuario(email, senha);
        
        if (usuario == null) {
            System.out.println("Email ou senha incorretos. Tente novamente.");
        }
        return usuario; 
    }
}
