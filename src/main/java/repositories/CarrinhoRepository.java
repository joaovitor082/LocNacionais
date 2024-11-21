package repositories;

import DAO.CarrinhoDAO;
import entities.Cliente;
import entities.Carrinho;
import repositories.Interfaces.ICarrinhoRepository;
import java.util.List;

public class CarrinhoRepository implements ICarrinhoRepository {
    private CarrinhoDAO carrinhoDAO;

    public CarrinhoRepository() {
        carrinhoDAO = new CarrinhoDAO();
    }

    public void salvar(Carrinho carrinho) {
        carrinhoDAO.salvar(carrinho);
    }

    public void atualizar(Carrinho carrinho) {
        carrinhoDAO.atualizar(carrinho);
    }

    public void deletarPorId(Carrinho carrinho) {
        carrinhoDAO.deletarPorId(carrinho);
    }

    public List<Carrinho> listarTodos() {
        return carrinhoDAO.listarTodos();
    }

    public Carrinho buscarPorId(int id) {
        return carrinhoDAO.buscarPorId(id);
    }

    public double totalPagar(Cliente cliente) {
        return carrinhoDAO.totalPagar(cliente);
    }
}
