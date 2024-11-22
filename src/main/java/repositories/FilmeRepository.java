package repositories;

import entities.Filme;
import DAO.FilmeDAO;
import repositories.Interfaces.IFilmeRepository;
import java.util.List;

public class FilmeRepository implements IFilmeRepository {
    private final FilmeDAO filmeDAO;

    public FilmeRepository() {
        this.filmeDAO = new FilmeDAO();
    }

    public void salvar(Filme filme) {
        filmeDAO.salvar(filme);
    }

    public Filme buscarPorId(int id) {
        return filmeDAO.buscarPorId(id);
    }

    public void atualizar(Filme filme) {
        filmeDAO.atualizar(filme);
    }

    public void deleterPorId(int id) {
        filmeDAO.deleterPorId(id);
    }

    public void alterarPreco(int id, double novoPreco) {
        filmeDAO.alterarPreco(id, novoPreco);
    }

    public List<Filme> buscarTodos() {
        return filmeDAO.listarTodos();
    }
}
