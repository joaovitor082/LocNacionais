package service;

import java.util.List;

import entities.Administrador;
import entities.Cliente;
import entities.Filme;
import repositories.AdministradorRepository;
import repositories.ClienteRepository;
import repositories.FilmeRepository;
import repositories.UsuarioRepository;
import repositories.Interfaces.IAdministradorService;

public class AdministradorService implements IAdministradorService {
    private AdministradorRepository administradorRepository;
    private ClienteRepository clienteRepository;
    private FilmeRepository filmeRepository;
    private UsuarioRepository usuarioRepository;

    public AdministradorService() {
        this.administradorRepository = new AdministradorRepository();
        this.clienteRepository = new ClienteRepository();
        this.filmeRepository = new FilmeRepository();
        this.usuarioRepository = new UsuarioRepository();
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
            List<Cliente> clientes = clienteRepository.buscarTodos();
            for (Cliente cliente : clientes) {
                System.out.println("\nID: " + cliente.getIdUsuario() + "\n" + "Nome: " + cliente.getNome() + "\n" + "Email: " + cliente.getEmail() + "\n" + cliente.getEndereco() + "\n" + cliente.getTelefone());
            }
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
            List<Filme> filmes = filmeRepository.buscarTodos();
            for (Filme filme : filmes) {
                System.out.println("\nID: " + filme.getIdFilme() + "\n" + "Titulo: " + filme.getTitulo() + "\n" + "Genero: " + filme.getGenero() + "\n" + "Sinopse: " + filme.getSinopse() + "\n" + "Duração: " + filme.getDuracao() + "\n" + "Classificação: " + filme.getClassificacao() + "\n" + "Diretor: " + filme.getDiretor() + "\n" + "Data de Lançamento: " + filme.getDataLancamento() + "\n" + "Disponivel: " + filme.isDisponivel() + "\n" + "Reservado: " + filme.isReservado() + "\n" + "Preço: " + filme.getPreco() + "\n");
            }
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
            usuarioRepository.deleterPorId(administradorRepository.buscarPorId(idAdministrador).getIdUsuario());
         } catch (Exception e) {
            System.out.println("Erro ao remover administrador: " + e.getMessage());
       }
    }

    public void listarAdministradores() {
        try{
             List<Administrador> administradores = administradorRepository.buscarTodos();
             for (Administrador administrador2 : administradores) {
                System.out.println("\nID: " + administrador2.getIdUsuario() + "\n" + "Nome: " + administrador2.getLogin() + "\n" + "Email: " + administrador2.getEmail() + "\n" + "Senha: " + administrador2.getSenha() + "\n");
             }
        } catch (Exception e) {
            System.out.println("Erro ao listar administradores: " + e.getMessage());
        }
    }

}
