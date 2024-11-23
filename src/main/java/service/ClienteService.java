package service;

import entities.Cliente;
import repositories.ClienteRepository;
import entities.Filme;
import repositories.FilmeRepository;

import java.util.List;
import repositories.Interfaces.IClienteService;

public class ClienteService implements IClienteService {
    private ClienteRepository clienteRepository;
    private FilmeRepository filmeRepository;
   

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
        this.filmeRepository = new FilmeRepository();
        
    }

    //metodos cliente
    public void cadastrar(Cliente cliente) {
        try{
            clienteRepository.salvar(cliente);
            
        } catch (Exception e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    public void alugarFilme(int idCliente, int idFilme) {
        try{
            Cliente cliente = clienteRepository.buscarPorId(idCliente);
            Filme filme = filmeRepository.buscarPorId(idFilme);
            if (filme.isDisponivel()) {
                if (!filme.isReservado()) {
                    filme.setDisponivel(false);
                } else {
                    System.out.println("Filme reservado, não pode ser alugado");
                }
            }else{
                System.out.println("Filme indisponível para aluguel");
            }
        } catch (Exception e) {
            System.out.println("Erro ao alugar filme: " + e.getMessage());
        }
    }

    public void reservarFilme(int idCliente, int idFilme) {
        try{
            Cliente cliente = clienteRepository.buscarPorId(idCliente);
            Filme filme = filmeRepository.buscarPorId(idFilme);
            if (filme.isDisponivel()) {
                if(!filme.isReservado()){
                    filme.setDisponivel(false);
                    filme.setReservado(true);
                }
            }else{
                System.out.println("Filme indisponível para reserva");
            }
        } catch (Exception e) {
            System.out.println("Erro ao reservar filme: " + e.getMessage());
        }
    }

    public void devolverFilme(Cliente cliente, Filme filme) {
        try{
            filme.setDisponivel(true);
            filme.setReservado(false);

        } catch (Exception e) {
            System.out.println("Erro ao devolver filme: " + e.getMessage());
        }
    }


    public void listarFilmes(){
        try{
            List<Filme> filmes = filmeRepository.buscarTodos();
            for (Filme filme : filmes) {
                 System.out.println("\nID: " + filme.getIdFilme() + "\n" + "Titulo: " + filme.getTitulo() + "\n" + "Genero: " + filme.getGenero() + "\n" + "Classificação: " + filme.getClassificacao() + "\n" + "Data de Lançamento: " + filme.getDataLancamento() + "\n" + "Disponivel: " + filme.isDisponivel() + "\n" + "Reservado: " + filme.isReservado() + "\n" + "Preço: " + filme.getPreco() + "\n");

            }
        } catch (Exception e) {
            System.out.println("Erro ao listar filmes: " + e.getMessage());
        }
    }

    public Filme buscarFilme(int idFilme){
        try{
            return filmeRepository.buscarPorId(idFilme);
        } catch (Exception e) {
            System.out.println("Erro ao buscar filme: " + e.getMessage());
            return null;
        }
    }
}
