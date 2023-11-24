package poo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import poo.model.Jogo;

public class JogoDAO {

    private final SessionFactory sessionFactory;

    public JogoDAO() {
        // Configurando a sessão do Hibernate a partir do arquivo hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public void salvarJogo(Jogo jogo) {
        executeInTransaction(session -> session.save(jogo));
    }

    public Jogo getJogoById(Long id) {
        return executeInTransaction(session -> session.get(Jogo.class, id));
    }

    public void atualizarJogo(Jogo jogo) {
        executeInTransaction(session -> {
            session.update(jogo);
            return null; // Não há valor de retorno específico nesta operação
        });
    }

    public void deletarJogo(Jogo jogo) {
        executeInTransaction(session -> {
            session.delete(jogo);
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
