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

    @Override
    public void salvar(Filme filme) {
        if (filme == null) {
            throw new IllegalArgumentException("Filme não pode ser nulo.");
        }
        filmeDAO.salvar(filme);
    }

    @Override
    public Filme buscarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca.");
        }
        Filme filme = filmeDAO.buscarPorId(id);
        if (filme == null) {
            throw new IllegalStateException("Filme não encontrado.");
        }
        return filme;
    }

    @Override
    public void atualizar(Filme filme) {
        if (filme == null || filme.getIdFilme() <= 0) {
            throw new IllegalArgumentException("Filme inválido para atualização.");
        }
        filmeDAO.atualizar(filme);
    }

    @Override
    public void deleterPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
        filmeDAO.deleterPorId(id);
    }

    @Override
    public void alterarPreco(int id, double novoPreco) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para alteração de preço.");
        }
        if (novoPreco <= 0) {
            throw new IllegalArgumentException("Preço inválido.");
        }
        filmeDAO.alterarPreco(id, novoPreco);
    }

    @Override
    public List<Filme> buscarTodos() {
        List<Filme> filmes = filmeDAO.listarTodos();
        if (filmes == null || filmes.isEmpty()) {
            throw new IllegalStateException("Nenhum filme encontrado.");
        }
        return filmes;
    }
}
