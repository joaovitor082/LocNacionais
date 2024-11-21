package repositories.Interfaces;

import entities.Cliente;

public interface IAdministradorService {
    void adicionarCliente(Cliente cliente);
    void removerCliente(int idCliente);
    void listarClientes();
    void cadastrarFilme(String titulo, String genero, String sinopse, String duracao, String classificacao, String diretor, String dataLancamento, boolean disponivel, boolean reservado, double preco);
    void removerFilme(int idFilme);
    void alterarPreco(int idFilme, double novoPreco);
}
