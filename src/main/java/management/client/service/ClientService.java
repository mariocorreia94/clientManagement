package management.client.service;

import management.client.model.Client;

import java.util.List;

public interface ClientService {

    void addClient(Client client);

    void removeClient(String nif);

    List<Client> findAll();

    List<Client> findByName(String clientName);

    Client findByNIF (String nif);

    void editClient(String nif, Client client);
}