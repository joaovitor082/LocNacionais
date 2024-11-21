package service;

import entities.Cliente;
import repositories.ClienteRepository;
import entities.Filme;
import repositories.FilmeRepository;
import entities.Carrinho;
import repositories.CarrinhoRepository;
import repositories.Interfaces.IClienteService;

public class ClienteService implements IClienteService {
    private ClienteRepository clienteRepository;
    private FilmeRepository filmeRepository;
    private CarrinhoRepository carrinhoRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
        this.filmeRepository = new FilmeRepository();
        this.carrinhoRepository = new CarrinhoRepository();
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
                    Carrinho carrinho = new Carrinho(filme, cliente, filme.getPreco());
                    carrinhoRepository.salvar(carrinho);
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
                    Carrinho carrinho = new Carrinho(filme, cliente, filme.getPreco());
                    carrinhoRepository.salvar(carrinho);
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

    public void devolverFilme(int idCliente, int idFilme) {
        try{
            Cliente cliente = clienteRepository.buscarPorId(idCliente);
            Filme filme = filmeRepository.buscarPorId(idFilme);
            filme.setDisponivel(true);
            filme.setReservado(false);
            //tem que fazer o carrinho ser deletado por id
        } catch (Exception e) {
            System.out.println("Erro ao devolver filme: " + e.getMessage());
        }
    }

    public double totalPagar(int idCliente) {
        try{
            Cliente cliente = clienteRepository.buscarPorId(idCliente);
            //TEM QUE APAGAR ESSE CARRINHO DE ALGUMA FORMA, NAO SEI COMO, MAS PRECISA SER POR IDCLIENTE
            return carrinhoRepository.totalPagar(cliente);
        } catch (Exception e) {
            System.out.println("Erro ao calcular total a pagar: " + e.getMessage());
            return 0;
        }
    }
}