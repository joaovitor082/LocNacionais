package repositories.Interfaces;

import java.util.List;

import entities.Administrador;

public interface IadministradorRepository {
    void salvar(Administrador administrador);
    void atualizar(Administrador administrador);
    void deletarPorId(int id);
    Administrador buscarPorId(int id);
    List<Administrador> buscarTodos();
}
