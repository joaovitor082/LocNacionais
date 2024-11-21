package repositories.Interfaces;

import entities.Carrinho;
import java.util.List;
import entities.Cliente;

public interface ICarrinhoRepository {
    void salvar(Carrinho carrinho);
    void atualizar(Carrinho carrinho);
    void deletarPorId(Carrinho carrinho);
    List<Carrinho> listarTodos();
    Carrinho buscarPorId(int id);
    double totalPagar(Cliente cliente);
}
