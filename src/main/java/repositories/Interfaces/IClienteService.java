package repositories.Interfaces;

import entities.Cliente;
import entities.Filme;
import entities.Carrinho;

public interface IClienteService {
    void cadastrar(Cliente cliente);
    void alugarFilme(int idCliente, int idFilme);
    void reservarFilme(int idCliente, int idFilme);
    void devolverFilme(int idCliente, int idFilme);
    void carrinhoServiceAtualizar(int idCliente, Filme filme, String operacao);
    void listarFilmes();
    Filme buscarFilme(int idFilme);
    Carrinho buscarOuCriarCarrinho(Cliente cliente);
}