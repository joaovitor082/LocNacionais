package repositories.Interfaces;

import entities.Filme;

public interface IFilmeRepository {
    void salvar(Filme filme);
    Filme buscarPorId(int id);
    void atualizar(Filme filme);
    void deleterPorId(int id);
    void listarTodos();
}
