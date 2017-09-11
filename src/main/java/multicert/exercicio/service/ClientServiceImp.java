package multicert.exercicio.service;

import multicert.exercicio.model.Client;
import multicert.exercicio.model.HibernateClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    private HibernateClient hibernateClient;

    @Transactional
    @Override
    public List<Client> findAll() {

        return hibernateClient.findAll();
    }

    @Transactional
    @Override
    public List<Client> findByName(String clientName) {

        return hibernateClient.findByName(clientName);
    }

    @Transactional
    @Override
    public void addClient(Client client) {

        hibernateClient.addClient(client);

    }

    @Transactional
    @Override
    public void removeClient(String nif) {

        hibernateClient.removeClient(nif);

    }

    @Transactional
    @Override
    public Client findByNIF(String nif) {

        return hibernateClient.findByNIF(nif);
    }

    @Transactional
    @Override
    public void editClient(String nif, Client client) {

        hibernateClient.editClient(nif, client);
    }

    public void setHibernateClient(HibernateClient hibernateClient) {
        this.hibernateClient = hibernateClient;
    }
}
