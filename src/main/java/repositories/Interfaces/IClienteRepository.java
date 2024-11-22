package repositories.Interfaces;

import entities.Cliente;
import java.util.List;

public interface IClienteRepository {
    void salvar(Cliente cliente);
    Cliente buscarPorId(int id);
    void atualizar(Cliente cliente);
    void deletarPorId(int id);
    List<Cliente> buscarTodos();
}
