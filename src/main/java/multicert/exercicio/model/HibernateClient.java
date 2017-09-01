package multicert.exercicio.model;


import multicert.exercicio.persistence.HibernateSessionManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HibernateClient {

    HibernateSessionManager sessionManager;

    public void addClient(Client client) {

        Session session = sessionManager.beginTransaction();

        session.save(client);

    }

    public void removeClient(String nif){

        Session session = sessionManager.beginTransaction();

        Query query = session.createQuery("DELETE Client WHERE nif = :nif");

        query.setString("nif", nif);

        query.executeUpdate();

    }

    public List<Client> findByName(String clientName) {

        Session session = sessionManager.beginTransaction();

        StringBuilder stringBuilder = new StringBuilder("FROM Client ");

        if(clientName != null && !clientName.isEmpty())
            stringBuilder.append("WHERE name LIKE :clientName");

        Query query = session.createQuery(stringBuilder.toString());

        if(clientName != null && !clientName.isEmpty())
            query.setString("clientName", "%" + clientName + "%");

        return (List<Client>) query.list();
    }

    @Transactional
    public Client findByNIF(String nif) {

        Session session = sessionManager.beginTransaction();

        Query query = session.createQuery("FROM Client WHERE nif = :nif");

        query.setString("nif", nif);

        return (Client) query.uniqueResult();
    }

    public void setSessionManager(HibernateSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}