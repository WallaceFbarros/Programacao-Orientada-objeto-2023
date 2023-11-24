package poo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import poo.model.Filme;

public class FilmeDAO {

    private final SessionFactory sessionFactory;

    public FilmeDAO() {
        // Configurando a sessão do Hibernate a partir do arquivo hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public void salvarFilme(Filme filme) {
        executeInTransaction(session -> session.save(filme));
    }

    public Filme getFilmeById(Long id) {
        return executeInTransaction(session -> session.get(Filme.class, id));
    }

    public void atualizarFilme(Filme filme) {
        executeInTransaction(session -> {
            session.update(filme);
            return null; // Não há valor de retorno específico nesta operação
        });
    }

    public void deletarFilme(Filme filme) {
        executeInTransaction(session -> {
            session.delete(filme);
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
