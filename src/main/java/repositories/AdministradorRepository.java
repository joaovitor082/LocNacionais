package repositories;

import DAO.AdministradorDAO;
import entities.Administrador;
import repositories.Interfaces.IadministradorRepository;

public class AdministradorRepository implements IadministradorRepository {
    private AdministradorDAO administradorDAO;

    public AdministradorRepository() {
        this.administradorDAO = new AdministradorDAO();
    }

    public void salvar(Administrador administrador) {
        this.administradorDAO.salvar(administrador);
    }

    public void atualizar(Administrador administrador) {
        this.administradorDAO.atualizar(administrador);
    }

    public void deletarPorId(int id) {
        this.administradorDAO.deleterPorId(id);
    }

    public Administrador buscarPorId(int id) {
        return this.administradorDAO.buscarPorId(id);
    }

    public void listarTodos() {
        this.administradorDAO.listarTodos();
    }
    
}