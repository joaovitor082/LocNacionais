package DAO;

import entities.Carrinho;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CarrinhoDAO {
    private final SessionFactory sessionFactory;

    public CarrinhoDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void salvar(Carrinho carrinho) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(carrinho);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Carrinho buscarPorId(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Carrinho.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void atualizar(Carrinho carrinho) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(carrinho);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleterPorId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Carrinho carrinho = session.get(Carrinho.class, id);
            session.delete(carrinho);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Carrinho> listarTodos() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Carrinho").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
