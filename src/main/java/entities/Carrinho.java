package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrinho")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrinho;
    @ManyToOne
    private Filme filme;
    @OneToOne
    private Cliente cliente;
    private double valorTotal;


    public Carrinho(Filme filme, Cliente cliente, double valorTotal) {
        this.filme = filme;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }

    public Filme getFilme() {
        return filme;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    
}
