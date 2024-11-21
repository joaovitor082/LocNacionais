package DAO;

import entities.Carrinho;
import entities.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class CarrinhoDAO {
    private static SessionFactory factory;

    public CarrinhoDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void salvar(Carrinho carrinho) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(carrinho);
        transaction.commit();
        session.close();
    }

    public void atualizar(Carrinho carrinho) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(carrinho);
        transaction.commit();
        session.close();
    }

    public void deletarPorId(Carrinho carrinho) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(carrinho);
        transaction.commit();
        session.close();
    }

    public List<Carrinho> listarTodos() {
        Session session = factory.openSession();
        List<Carrinho> carrinhos = session.createQuery("from Carrinho").list();
        session.close();
        return carrinhos;
    }

    public Carrinho buscarPorId(int id) {
        Session session = factory.openSession();
        Carrinho carrinho = session.get(Carrinho.class, id);
        session.close();
        return carrinho;
    }

    public double totalPagar(Cliente cliente) {
        Session session = factory.openSession();
                double total = (double) session.createQuery("select sum(preco) from Carrinho where cliente = :cliente").setParameter("cliente", cliente).getSingleResult();
        session.close();
        return total;
    }
}
