package service;

import entities.Cliente;
import entities.Carrinho;
import repositories.ClienteRepository;
import entities.Filme;
import jakarta.transaction.Transactional;
import repositories.FilmeRepository;
import repositories.CarrinhoRepository;
import repositories.Interfaces.IClienteService;

import java.util.List;

public class ClienteService implements IClienteService {
    private ClienteRepository clienteRepository;
    private FilmeRepository filmeRepository;
    private CarrinhoRepository carrinhoRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
        this.filmeRepository = new FilmeRepository();
        this.carrinhoRepository = new CarrinhoRepository();
    }

    // Métodos cliente
    public void cadastrar(Cliente cliente) {
        try {
            clienteRepository.salvar(cliente);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    // Método para alugar filme
    @Transactional
    public void alugarFilme(int idCliente, int idFilme) {
        try {
            Cliente cliente = clienteRepository.buscarPorId(idCliente);
            Filme filme = filmeRepository.buscarPorId(idFilme);

            if (filme.isDisponivel()) {
                if (!filme.isReservado()) {
                    filme.setDisponivel(false); // O filme é alugado
                    filme.setReservado(false);  // Filme não está mais reservado

                    // Atualiza o carrinho para refletir o aluguel
                    carrinhoServiceAtualizar(idCliente, filme, "alugar");
                    filmeRepository.atualizar(filme); // Atualiza a disponibilidade do filme no banco
                    System.out.println("Filme alugado com sucesso.");
                } else {
                    System.out.println("Filme reservado, não pode ser alugado.");
                }
            } else {
                System.out.println("Filme indisponível para aluguel.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao alugar filme: " + e.getMessage());
        }
    }

    // Método para reservar filme
    @Transactional
    public void reservarFilme(int idCliente, int idFilme) {
        try {
            Cliente cliente = clienteRepository.buscarPorId(idCliente);
            Filme filme = filmeRepository.buscarPorId(idFilme);

            if (filme.isDisponivel()) {
                filme.setDisponivel(false); // O filme passa a não estar disponível
                filme.setReservado(true);   // Marca o filme como reservado
                carrinhoServiceAtualizar(idCliente, filme, "reservar");
                filmeRepository.atualizar(filme);
                System.out.println("Filme reservado com sucesso.");
            } else {
                System.out.println("Filme não disponível para reserva.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao reservar filme: " + e.getMessage());
        }
    }

    // Método para devolver filme
    @Transactional
    public void devolverFilme(int idCliente, int idFilme) {
        try {
            Cliente cliente = clienteRepository.buscarPorId(idCliente);
            Filme filme = filmeRepository.buscarPorId(idFilme);

            if (!filme.isDisponivel() && !filme.isReservado()) {
                filme.setDisponivel(true);  
                filme.setReservado(false);  
                filmeRepository.atualizar(filme);
                carrinhoServiceAtualizar(idCliente, filme, "devolver");
                System.out.println("Filme devolvido com sucesso.");
            } else {
                System.out.println("Filme não está reservado ou disponível para devolução.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao devolver filme: " + e.getMessage());
        }
    }

    // Método auxiliar para atualizar o carrinho
    public void carrinhoServiceAtualizar(int idCliente, Filme filme, String acao) {
        try {
            // Buscar o cliente e o carrinho atual
            Cliente cliente = clienteRepository.buscarPorId(idCliente);
            Carrinho carrinho = buscarOuCriarCarrinho(cliente);

            // Garantir que o filme não seja nulo ao atualizar o carrinho
            if ("alugar".equals(acao) || "reservar".equals(acao)) {
                if (filme != null) {
                    carrinho.setFilmeReservado(filme);
                }
            } else if ("devolver".equals(acao)) {
                carrinho.setFilmeReservado(null);
            }

            // Atualizar o carrinho no repositório
            carrinhoRepository.atualizar(carrinho);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o carrinho: " + e.getMessage());
        }
    }

    // Método para buscar ou criar um carrinho
    public Carrinho buscarOuCriarCarrinho(Cliente cliente) {
        Carrinho carrinho = carrinhoRepository.buscarPorId(cliente.getIdUsuario());
        if (carrinho == null) {
            carrinho = new Carrinho(cliente, null);  // Criando um carrinho vazio para um cliente
            carrinhoRepository.salvar(carrinho);
        }
        return carrinho;
    }

    // Método para listar todos os filmes
    public void listarFilmes() {
        try {
            List<Filme> filmes = filmeRepository.buscarTodos();
            for (Filme filme : filmes) {
                System.out.println("\nID: " + filme.getIdFilme() + "\n" + "Titulo: " + filme.getTitulo() + "\n" + "Genero: " + filme.getGenero() + "\n" + "Classificação: " + filme.getClassificacao() + "\n" + "Data de Lançamento: " + filme.getDataLancamento() + "\n" + "Disponivel: " + filme.isDisponivel() + "\n" + "Reservado: " + filme.isReservado() + "\n" + "Preço: " + filme.getPreco() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar filmes: " + e.getMessage());
        }
    }

    // Método para buscar um filme específico
    public Filme buscarFilme(int idFilme) {
        try {
            return filmeRepository.buscarPorId(idFilme);
        } catch (Exception e) {
            System.out.println("Erro ao buscar filme: " + e.getMessage());
            return null;
        }
    }
}
