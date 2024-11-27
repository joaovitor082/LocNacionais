package repositories;

import DAO.AdministradorDAO;
import entities.Administrador;
import repositories.Interfaces.IadministradorRepository;
import java.util.List;

public class AdministradorRepository implements IadministradorRepository {
    private final AdministradorDAO administradorDAO;

    public AdministradorRepository() {
        this.administradorDAO = new AdministradorDAO();
    }

    @Override
    public void salvar(Administrador administrador) {
        if (administrador == null) {
            throw new IllegalArgumentException("Administrador não pode ser nulo.");
        }
        this.administradorDAO.salvar(administrador);
    }

    @Override
    public void atualizar(Administrador administrador) {
        if (administrador == null || administrador.getIdUsuario() <= 0) {
            throw new IllegalArgumentException("Administrador inválido para atualização.");
        }
        this.administradorDAO.atualizar(administrador);
    }

    @Override
    public void deletarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
        this.administradorDAO.deleterPorId(id);
    }

    @Override
    public Administrador buscarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca.");
        }
        return this.administradorDAO.buscarPorId(id);
    }

    @Override
    public List<Administrador> buscarTodos() {
        List<Administrador> administradores = this.administradorDAO.listarTodos();
        if (administradores == null || administradores.isEmpty()) {
            throw new IllegalStateException("Nenhum administrador encontrado.");
        }
        return administradores;
    }
}
