package service;

import entities.Carrinho;
import jakarta.transaction.Transactional;
import repositories.CarrinhoRepository;

import java.util.List;



public class CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;

    public CarrinhoService() {
        this.carrinhoRepository = new CarrinhoRepository();
    }

    @Transactional
    public void adicionarCarrinho(Carrinho carrinho) {
        if (carrinho.getFilmeReservado() == null) {
        throw new IllegalArgumentException("O filme reservado não pode ser null.");
        }
    carrinhoRepository.salvar(carrinho);
}

    @Transactional
    public void atualizarCarrinho(Carrinho carrinho) {
        carrinhoRepository.atualizar(carrinho);
    }

    @SuppressWarnings("null")
    @Transactional
    public Carrinho buscarCarrinhoPorId(int id) {
        return carrinhoRepository.buscarPorId(id);
        
    }

    @Transactional
    public void removerCarrinho(int id) {
        carrinhoRepository.deletarPorId(id);
    }

    @Transactional
    public List<Carrinho> listarCarrinhos() {
        return carrinhoRepository.buscarTodos();
    }

    public double calcularPrecoTotal(Carrinho carrinho) {
        return carrinho.getTotalPreco();
    }
}
