package repositories.Interfaces;

import entities.Cliente;
import entities.Filme;

public interface IClienteService {
    void cadastrar(Cliente cliente);
    void alugarFilme(int idCliente, int idFilme);
    void reservarFilme(int idCliente, int idFilme);
    void devolverFilme(Cliente cliente, Filme filme);
    void listarFilmes();
    Filme buscarFilme(int idFilme);
}