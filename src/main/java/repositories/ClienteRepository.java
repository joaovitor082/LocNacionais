package repositories;

import entities.Cliente;
import DAO.ClienteDAO;
import repositories.Interfaces.IClienteRepository;

public class ClienteRepository implements IClienteRepository {
    private final ClienteDAO clienteDAO;

    public ClienteRepository() {
        this.clienteDAO = new ClienteDAO();
    }

    public void salvar(Cliente cliente) {
        clienteDAO.salvar(cliente);
    }

    public Cliente buscarPorId(int id) {
        return clienteDAO.buscarPorId(id);
    }

    public void atualizar(Cliente cliente) {
        clienteDAO.atualizar(cliente);
    }

    public void deletarPorId(int id) {
        clienteDAO.deleterPorId(id);
    }

    public void listarTodos(){
        clienteDAO.listarTodos();
    }
}
