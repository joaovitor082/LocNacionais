package repositories;

import DAO.UsuarioDAO;
import entities.Usuario;
import repositories.Interfaces.IUsuarioRepository;

import java.util.List;

public class UsuarioRepository implements IUsuarioRepository {
    private final UsuarioDAO usuarioDAO;

    public UsuarioRepository() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public void salvar(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        usuarioDAO.salvar(usuario);
    }

    @Override
    public Usuario buscarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca.");
        }
        return usuarioDAO.buscarPorId(id);
    }

    @Override
    public void atualizar(Usuario usuario) {
        if (usuario == null || usuario.getIdUsuario() <= 0) {
            throw new IllegalArgumentException("Usuário inválido para atualização.");
        }
        usuarioDAO.atualizar(usuario);
    }

    @Override
    public void deleterPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
        usuarioDAO.deleterPorId(id);
    }

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = usuarioDAO.listarTodos();
        if (usuarios == null || usuarios.isEmpty()) {
            throw new IllegalStateException("Nenhum usuário encontrado.");
        }
        return usuarios;
    }

    @Override
    public boolean checarLogin(String email, String senha) {
        if (email == null || senha == null) {
            throw new IllegalArgumentException("Email ou senha não podem ser nulos.");
        }
        return usuarioDAO.checarLogin(email, senha);
    }

    @Override
    public Usuario buscarUsuario(String email, String senha) {
        if (email == null || senha == null) {
            throw new IllegalArgumentException("Email ou senha não podem ser nulos.");
        }
        Usuario usuario = usuarioDAO.buscarUsuario(email, senha);
        
        return usuario; 
    }
}
