package repositories.Interfaces;

import entities.Cliente;

public interface IClienteRepository {
    void salvar(Cliente cliente);
    Cliente buscarPorId(int id);
    void atualizar(Cliente cliente);
    void deletarPorId(int id);
    void listarTodos();
}
