package DAO;

import entities.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class UsuarioDAO {
    private final SessionFactory sessionFactory;

    public UsuarioDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
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
            e.printStackTrace();
        }
    }

    public Usuario buscarPorId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            return session.get(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
            e.printStackTrace();
        }
    }

    public void deleterPorId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            session.delete(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public boolean checarLogin(String email, String senha) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Usuario usuario = (Usuario) session.createQuery("from Usuario where email = :email")
                    .setParameter("email", email).uniqueResult();
            return usuario.getSenha().equals(senha);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }


    public List<Usuario> listarTodos() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            return session.createQuery("from Usuario").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
