package repositories.Interfaces;

import entities.Filme;
import java.util.List;

public interface IFilmeRepository {
    void salvar(Filme filme);
    Filme buscarPorId(int id);
    void atualizar(Filme filme);
    void deleterPorId(int id);
    List<Filme> buscarTodos();
    void alterarPreco(int id, double novoPreco);
    
}
