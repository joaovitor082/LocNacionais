package repositories.Interfaces;

import entities.Carrinho;
import java.util.List;

public interface ICarrinhoRepository {
    void salvar(Carrinho carrinho);
    Carrinho buscarPorId(int id);
    void atualizar(Carrinho carrinho);
    void deletarPorId(int id);
    List<Carrinho> buscarTodos();
}
