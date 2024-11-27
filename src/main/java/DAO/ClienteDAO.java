package DAO;

import entities.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ClienteDAO {
    private static final SessionFactory sessionFactory;
    
    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void salvar(Cliente cliente) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao salvar cliente.", e);
        } finally {
            session.close();
        }
    }

    public Cliente buscarPorId(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Cliente.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente por ID.", e);
        } finally {
            session.close();
        }
    }

    public void atualizar(Cliente cliente) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao atualizar cliente.", e);
        } finally {
            session.close();
        }
    }

    public void deleterPorId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, id);
            if (cliente != null) {
                session.delete(cliente);
                transaction.commit();
            } else {
                System.out.println("Cliente com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao deletar cliente.", e);
        } finally {
            session.close();
        }
    }

    public List<Cliente> listarTodos() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Cliente", Cliente.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar clientes.", e);
        } finally {
            session.close();
        }
    }

    public static void fechar() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
