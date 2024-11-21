package repositories.Interfaces;

import entities.Cliente;

public interface IClienteService {
    void cadastrar(Cliente cliente);
    void alugarFilme(int idCliente, int idFilme);
    void reservarFilme(int idCliente, int idFilme);
    void devolverFilme(int idCliente, int idFilme);
    double totalPagar(int idCliente);
}