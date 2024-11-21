package repositories.Interfaces;

import entities.Administrador;

public interface IadministradorRepository {
    void salvar(Administrador administrador);
    void atualizar(Administrador administrador);
    void deletarPorId(int id);
    Administrador buscarPorId(int id);
    void listarTodos();
}
