package poo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import poo.model.Musica;

public class MusicaDAO {

    private final SessionFactory sessionFactory;

    public MusicaDAO() {
        // Configurando a sessão do Hibernate a partir do arquivo hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public void salvarMusica(Musica musica) {
        executeInTransaction(session -> session.save(musica));
    }

    public Musica getMusicaById(Long id) {
        return executeInTransaction(session -> session.get(Musica.class, id));
    }

    public void atualizarMusica(Musica musica) {
        executeInTransaction(session -> {
            session.update(musica);
            return null; // Não há valor de retorno específico nesta operação
        });
    }

    public void deletarMusica(Musica musica) {
        executeInTransaction(session -> {
            session.delete(musica);
            return null; // Não há valor de retorno específico nesta operação
        });
    }

    private <T> T executeInTransaction(SessionOperation<T> operation) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        
        try {
            transaction = session.beginTransaction();
            T result = operation.execute(session);
            transaction.commit();
            return result;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void close() {
        sessionFactory.close();
    }

    @FunctionalInterface
    private interface SessionOperation<T> {
        T execute(Session session);
    }
}
