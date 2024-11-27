package repositories.Interfaces;

import java.util.List;

import entities.Usuario;

public interface IUsuarioRepository {
    void salvar(Usuario usuario);
    Usuario buscarPorId(int id);
    void atualizar(Usuario usuario);
    void deleterPorId(int id);
    List<Usuario> listarTodos();
    boolean checarLogin(String email, String senha);
    Usuario buscarUsuario(String email, String senha);
}
