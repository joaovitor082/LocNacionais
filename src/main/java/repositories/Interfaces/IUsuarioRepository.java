package repositories.Interfaces;

import entities.Usuario;

public interface IUsuarioRepository {
    void salvar(Usuario usuario);
    Usuario buscarPorId(int id);
    void atualizar(Usuario usuario);
    void deleterPorId(int id);
    void listarTodos();
}
