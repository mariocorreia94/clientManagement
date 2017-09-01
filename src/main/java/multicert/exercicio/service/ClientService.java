package multicert.exercicio.service;

import multicert.exercicio.model.Client;

import java.util.List;

public interface ClientService {

    void addClient(Client client);

    void removeClient(String nif);

    List<Client> findByName(String clientName);

    Client findByNIF (String nif);

}