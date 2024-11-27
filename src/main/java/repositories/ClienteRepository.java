package repositories;

import entities.Cliente;
import DAO.ClienteDAO;
import repositories.Interfaces.IClienteRepository;
import java.util.List;

public class ClienteRepository implements IClienteRepository {
    private final ClienteDAO clienteDAO;

    public ClienteRepository() {
        this.clienteDAO = new ClienteDAO();
    }

    @Override
    public void salvar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }
        clienteDAO.salvar(cliente);
    }

    @Override
    public Cliente buscarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca.");
        }
        Cliente cliente = clienteDAO.buscarPorId(id);
        if (cliente == null) {
            throw new IllegalStateException("Cliente não encontrado.");
        }
        return cliente;
    }

    @Override
    public void atualizar(Cliente cliente) {
        if (cliente == null || cliente.getIdUsuario() <= 0) {
            throw new IllegalArgumentException("Cliente inválido para atualização.");
        }
        clienteDAO.atualizar(cliente);
    }

    @Override
    public void deletarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
        clienteDAO.deleterPorId(id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        List<Cliente> clientes = clienteDAO.listarTodos();
        if (clientes == null || clientes.isEmpty()) {
            throw new IllegalStateException("Nenhum cliente encontrado.");
        }
        return clientes;
    }
}
