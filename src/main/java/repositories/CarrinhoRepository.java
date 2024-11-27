package repositories;

import DAO.CarrinhoDAO;
import entities.Carrinho;
import repositories.Interfaces.ICarrinhoRepository;

import java.util.List;

public class CarrinhoRepository implements ICarrinhoRepository {
    private final CarrinhoDAO carrinhoDAO;

    public CarrinhoRepository() {
        this.carrinhoDAO = new CarrinhoDAO();
    }

    public void salvar(Carrinho carrinho) {
        carrinhoDAO.salvar(carrinho);
    }

    public Carrinho buscarPorId(int id) {
        return carrinhoDAO.buscarPorId(id);
    }

    public void atualizar(Carrinho carrinho) {
        carrinhoDAO.atualizar(carrinho);
    }

    public void deletarPorId(int id) {
        carrinhoDAO.deleterPorId(id);
    }

    public List<Carrinho> buscarTodos() {
        return carrinhoDAO.listarTodos();
    }

}
