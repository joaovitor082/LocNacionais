package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrinho;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idFilme", nullable = true)
    private Filme filmeReservado;

    private double totalPreco;

    @Version  // Usando otimistic locking
    private int version;

    public Carrinho() {
    }

    public Carrinho(Cliente cliente, Filme filmeReservado) {
        this.cliente = cliente;
        this.filmeReservado = filmeReservado;
        this.totalPreco = calcularPrecoTotal();
    }

    public double calcularPrecoTotal() {
        if (filmeReservado != null && filmeReservado.isReservado()) {
            return filmeReservado.getPreco();
        }
        return 0.0;
    }

    // Getters e Setters
    public int getIdCarrinho() {
        return idCarrinho;
    }

    public double getTotalPreco() {
        return totalPreco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Filme getFilmeReservado() {
        return filmeReservado;
    }

    public void setFilmeReservado(Filme filmeReservado) {
        this.filmeReservado = filmeReservado;
        this.totalPreco = calcularPrecoTotal();  // Atualiza o preço total quando o filme for alterado
    }

    public void setTotalPreco(double calcularPrecoTotal) {
        this.totalPreco = calcularPrecoTotal;
    }
}
