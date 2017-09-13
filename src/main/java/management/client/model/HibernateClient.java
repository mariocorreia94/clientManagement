package management.client.model;


import management.client.persistence.HibernateSessionManager;
import org.hibernate.Query;
import org.hibernate.Session;

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

        Query query = session.createQuery("FROM Client WHERE name LIKE :clientName");

        if(clientName != null && !clientName.isEmpty())
            query.setString("clientName", "%" + clientName + "%");

        return (List<Client>) query.list();
    }

    public List<Client> findAll() {

        Session session = sessionManager.beginTransaction();

        Query query = session.createQuery("FROM Client");

        return (List<Client>) query.list();

    }

    public Client findByNIF(String nif) {

        Session session = sessionManager.beginTransaction();

        Query query = session.createQuery("FROM Client WHERE nif = :nif");

        query.setString("nif", nif);


        return (Client) query.uniqueResult();
    }

    public void editClient(String nif, Client client) {

        Session session = sessionManager.beginTransaction();

        Client clientToUpdate = findByNIF(nif);

        clientToUpdate.setName(client.getName());
        clientToUpdate.setAdress(client.getAdress());
        clientToUpdate.setPhone(client.getPhone());

        session.saveOrUpdate(clientToUpdate);

    }

    public void setSessionManager(HibernateSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}