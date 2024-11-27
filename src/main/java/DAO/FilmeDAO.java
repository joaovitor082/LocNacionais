package DAO;

import entities.Filme;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FilmeDAO {
    private static final SessionFactory sessionFactory;

    // Inicialização estática do SessionFactory
    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void salvar(Filme filme) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(filme);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao salvar filme.", e);
        } finally {
            session.close();
        }
    }

    public Filme buscarPorId(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Filme.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar filme por ID.", e);
        } finally {
            session.close();
        }
    }

    public void atualizar(Filme filme) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(filme);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao atualizar filme.", e);
        } finally {
            session.close();
        }
    }

    public void deleterPorId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Filme filme = session.get(Filme.class, id);
            if (filme != null) {
                session.delete(filme);
                transaction.commit();
            } else {
                System.out.println("Filme com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao deletar filme.", e);
        } finally {
            session.close();
        }
    }

    public List<Filme> listarTodos() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Filme", Filme.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar filmes.", e);
        } finally {
            session.close();
        }
    }

    public void alterarPreco(int id, double novoPreco) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Filme filme = session.get(Filme.class, id);
            if (filme != null) {
                filme.setPreco(novoPreco);
                session.update(filme);
                transaction.commit();
            } else {
                System.out.println("Filme com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao alterar preço do filme.", e);
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
