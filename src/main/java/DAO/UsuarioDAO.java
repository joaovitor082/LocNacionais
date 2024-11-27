package DAO;

import entities.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UsuarioDAO {
    private static final SessionFactory sessionFactory;

    // Inicialização estática do SessionFactory
    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void salvar(Usuario usuario) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao salvar usuário.", e);
        } finally {
            session.close();
        }
    }

    public Usuario buscarPorId(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Usuario.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar usuário por ID.", e);
        } finally {
            session.close();
        }
    }

    public void atualizar(Usuario usuario) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao atualizar usuário.", e);
        } finally {
            session.close();
        }
    }

    public void deleterPorId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            if (usuario != null) {
                session.delete(usuario);
                transaction.commit();
            } else {
                System.out.println("Usuário com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erro ao deletar usuário.", e);
        } finally {
            session.close();
        }
    }

    public boolean checarLogin(String email, String senha) {
        Session session = sessionFactory.openSession();
        try {
            Usuario usuario = (Usuario) session.createQuery("from Usuario where email = :email")
                    .setParameter("email", email)
                    .uniqueResult();
            if (usuario != null) {
                return usuario.getSenha().equals(senha);
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao checar login.", e);
        } finally {
            session.close();
        }
    }

    public Usuario buscarUsuario(String email, String senha) {
        Session session = sessionFactory.openSession();
        try {
            return (Usuario) session.createQuery("from Usuario where email = :email and senha = :senha")
                    .setParameter("email", email)
                    .setParameter("senha", senha)
                    .uniqueResult();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar usuário por email e senha.", e);
        } finally {
            session.close();
        }
    }

    public List<Usuario> listarTodos() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Usuario", Usuario.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar usuários.", e);
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
