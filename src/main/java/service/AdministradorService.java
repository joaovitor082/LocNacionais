package service;

import entities.Administrador;
import entities.Cliente;
import entities.Filme;
import repositories.AdministradorRepository;
import repositories.ClienteRepository;
import repositories.FilmeRepository;
import repositories.Interfaces.IAdministradorService;

public class AdministradorService implements IAdministradorService {
    private AdministradorRepository administradorRepository;
    private ClienteRepository clienteRepository;
    private FilmeRepository filmeRepository;

    public AdministradorService() {
        this.administradorRepository = new AdministradorRepository();
        this.clienteRepository = new ClienteRepository();
        this.filmeRepository = new FilmeRepository();
    }

    //metodos clientes
    public void adicionarCliente(Cliente cliente) {
        try{
            clienteRepository.salvar(cliente);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    public void removerCliente(int idCliente) {
       try{
            clienteRepository.deletarPorId(idCliente);
        } catch (Exception e) {
            System.out.println("Erro ao remover cliente: " + e.getMessage());
       }
    }

    public void listarClientes() {
        try{
            clienteRepository.listarTodos();
        } catch (Exception e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
    }

    //metodos Filmes
    public void cadastrarFilme(String titulo, String genero, String sinopse, String duracao, String classificacao, String diretor, String dataLancamento, boolean disponivel, boolean reservado, double preco) {
        try{
            Filme filme = new Filme(titulo, genero, sinopse, duracao, classificacao, diretor, dataLancamento, disponivel, reservado, preco);
            filmeRepository.salvar(filme);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar filme: " + e.getMessage());
        }
    }

    public void removerFilme(int idFilme) {
        try{
            filmeRepository.deleterPorId(idFilme);
        } catch (Exception e) {
            System.out.println("Erro ao remover filme: " + e.getMessage());
        }
    }

    public void listarFilmes() {
        try{
            filmeRepository.listarTodos();
        } catch (Exception e) {
            System.out.println("Erro ao listar filmes: " + e.getMessage());
        }
    }

    public void alterarPreco(int idFilme, double novoPreco) {
        try{
            filmeRepository.alterarPreco(idFilme, novoPreco);
        } catch (Exception e) {
            System.out.println("Erro ao alterar preço: " + e.getMessage());
        }
    }
    //metodos administradores
    public void adicionarAdministrador(Administrador administrador) {
        try{
            administradorRepository.salvar(administrador);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar administrador: " + e.getMessage());
        }
    }

    public void removerAdministrador(int idAdministrador) {
       try{
            administradorRepository.deletarPorId(idAdministrador);
         } catch (Exception e) {
            System.out.println("Erro ao remover administrador: " + e.getMessage());
       }
    }

    public void listarAdministradores() {
        try{
            administradorRepository.listarTodos();
        } catch (Exception e) {
            System.out.println("Erro ao listar administradores: " + e.getMessage());
        }
    }

}
