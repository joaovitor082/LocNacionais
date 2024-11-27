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
    private final AdministradorRepository administradorRepository;
    private final ClienteRepository clienteRepository;
    private final FilmeRepository filmeRepository;
    private final UsuarioRepository usuarioRepository;

    public AdministradorService() {
        this.administradorRepository = new AdministradorRepository();
        this.clienteRepository = new ClienteRepository();
        this.filmeRepository = new FilmeRepository();
        this.usuarioRepository = new UsuarioRepository();
    }

    // Métodos Clientes
    public void adicionarCliente(Cliente cliente) {
        try {
            if (cliente == null) {
                throw new IllegalArgumentException("Cliente não pode ser nulo.");
            }
            clienteRepository.salvar(cliente);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    public void removerCliente(int idCliente) {
        try {
            if (idCliente <= 0) {
                throw new IllegalArgumentException("ID do cliente inválido.");
            }
            clienteRepository.deletarPorId(idCliente);
        } catch (Exception e) {
            System.out.println("Erro ao remover cliente: " + e.getMessage());
        }
    }

    public void listarClientes() {
        try {
            List<Cliente> clientes = clienteRepository.buscarTodos();
            if (clientes.isEmpty()) {
                System.out.println("Nenhum cliente encontrado.");
                return;
            }
            for (Cliente cliente : clientes) {
                System.out.println("\nID: " + cliente.getIdUsuario() + "\nNome: " + cliente.getNome() + 
                    "\nEmail: " + cliente.getEmail() + "\nEndereço: " + cliente.getEndereco() + 
                    "\nTelefone: " + cliente.getTelefone());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
    }

    // Métodos Filmes
    public void cadastrarFilme(String titulo, String genero, String sinopse, String duracao, String classificacao, 
            String diretor, String dataLancamento, boolean disponivel, boolean reservado, double preco) {
        try {
            Filme filme = new Filme(titulo, genero, sinopse, duracao, classificacao, diretor, dataLancamento, disponivel, reservado, preco);
            filmeRepository.salvar(filme);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar filme: " + e.getMessage());
        }
    }

    public void removerFilme(int idFilme) {
        try {
            if (idFilme <= 0) {
                throw new IllegalArgumentException("ID do filme inválido.");
            }
            filmeRepository.deleterPorId(idFilme);
        } catch (Exception e) {
            System.out.println("Erro ao remover filme: " + e.getMessage());
        }
    }

    public void listarFilmes() {
        try {
            List<Filme> filmes = filmeRepository.buscarTodos();
            if (filmes.isEmpty()) {
                System.out.println("Nenhum filme encontrado.");
                return;
            }
            for (Filme filme : filmes) {
                System.out.println("\nID: " + filme.getIdFilme() + "\nTítulo: " + filme.getTitulo() + 
                    "\nGênero: " + filme.getGenero() + "\nClassificação: " + filme.getClassificacao() + 
                    "\nData de Lançamento: " + filme.getDataLancamento() + "\nDisponível: " + filme.isDisponivel() + 
                    "\nReservado: " + filme.isReservado() + "\nPreço: " + filme.getPreco());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar filmes: " + e.getMessage());
        }
    }

    public void alterarPreco(int idFilme, double novoPreco) {
        try {
            if (idFilme <= 0 || novoPreco <= 0) {
                throw new IllegalArgumentException("ID do filme ou preço inválido.");
            }
            filmeRepository.alterarPreco(idFilme, novoPreco);
        } catch (Exception e) {
            System.out.println("Erro ao alterar preço: " + e.getMessage());
        }
    }

    // Métodos Administradores
    public void adicionarAdministrador(Administrador administrador) {
        try {
            if (administrador == null) {
                throw new IllegalArgumentException("Administrador não pode ser nulo.");
            }
            administradorRepository.salvar(administrador);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar administrador: " + e.getMessage());
        }
    }

    public void removerAdministrador(int idAdministrador) {
        try {
            if (idAdministrador <= 0) {
                throw new IllegalArgumentException("ID do administrador inválido.");
            }
            administradorRepository.deletarPorId(idAdministrador);
            usuarioRepository.deleterPorId(administradorRepository.buscarPorId(idAdministrador).getIdUsuario());
        } catch (Exception e) {
            System.out.println("Erro ao remover administrador: " + e.getMessage());
        }
    }

    public void listarAdministradores() {
        try {
            List<Administrador> administradores = administradorRepository.buscarTodos();
            if (administradores.isEmpty()) {
                System.out.println("Nenhum administrador encontrado.");
                return;
            }
            for (Administrador administrador : administradores) {
                System.out.println("\nID: " + administrador.getIdUsuario() + "\nNome: " + administrador.getLogin() + 
                    "\nEmail: " + administrador.getEmail() + "\nSenha: " + administrador.getSenha());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar administradores: " + e.getMessage());
        }
    }
}
