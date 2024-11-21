package repositories;

import DAO.UsuarioDAO;
import entities.Usuario;
import repositories.Interfaces.IUsuarioRepository;

public class UsuarioRepository implements IUsuarioRepository {
    private UsuarioDAO usuarioDAO;

    public UsuarioRepository() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void salvar(Usuario usuario) {
        usuarioDAO.salvar(usuario);
    }

    public Usuario buscarPorId(int id) {
        return usuarioDAO.buscarPorId(id);
    }

    public void atualizar(Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }

    public void deleterPorId(int id) {
        usuarioDAO.deleterPorId(id);
    }

    public void listarTodos(){
        usuarioDAO.listarTodos();
    }

}

