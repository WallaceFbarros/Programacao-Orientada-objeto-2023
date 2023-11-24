package poo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import poo.model.Serie;

public class SerieDAO {

    private final SessionFactory sessionFactory;

    public SerieDAO() {
        // Configurando a sessão do Hibernate a partir do arquivo hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public void salvarSerie(Serie serie) {
        executeInTransaction(session -> session.save(serie));
    }

    public Serie getSerieById(Long id) {
        return executeInTransaction(session -> session.get(Serie.class, id));
    }

    public void atualizarSerie(Serie serie) {
        executeInTransaction(session -> {
            session.update(serie);
            return null; // Não há valor de retorno específico nesta operação
        });
    }

    public void deletarSerie(Serie serie) {
        executeInTransaction(session -> {
            session.delete(serie);
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
