package service;

import repositories.UsuarioRepository;
import entities.Usuario;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public Usuario buscarPorId(int id) {
        return usuarioRepository.buscarPorId(id);
    }

    public boolean checarLogin(String email, String senha){
        return usuarioRepository.checarLogin(email, senha);
    }

    public Usuario buscarUsuario(String email, String senha){
        return usuarioRepository.buscarUsuario(email, senha);
    }
}
