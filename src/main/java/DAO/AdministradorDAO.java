package DAO;

import entities.Administrador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class AdministradorDAO {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void salvar(Administrador administrador) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(administrador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao salvar administrador.", e);
        } finally {
            session.close();
        }
    }

    public Administrador buscarPorId(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Administrador.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar administrador por ID.", e);
        } finally {
            session.close();
        }
    }

    public void atualizar(Administrador administrador) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(administrador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao atualizar administrador.", e);
        } finally {
            session.close();
        }
    }

    public void deleterPorId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Administrador administrador = session.get(Administrador.class, id);
            if (administrador != null) {
                session.delete(administrador);
                transaction.commit();
            } else {
                System.out.println("Administrador com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao deletar administrador.", e);
        } finally {
            session.close();
        }
    }

    public List<Administrador> listarTodos() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Administrador", Administrador.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar administradores.", e);
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
