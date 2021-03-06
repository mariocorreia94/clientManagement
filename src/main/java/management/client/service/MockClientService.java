package management.client.service;

import management.client.model.Client;

import java.util.LinkedList;
import java.util.List;

public class MockClientService implements ClientService {

    private List<Client> clientList = new LinkedList<>();

    @Override
    public void addClient(Client client) {
        clientList.add(client);
    }

    @Override
    public void removeClient(String nif) {
        clientList.remove(findByNIF(nif));
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public List<Client> findByName(String username) {

        Client client = null;

        for (int i = 0; i < clientList.size(); i++) {

            if (clientList.get(i).getName().equals(username)) {
                client = clientList.get(i);
                return null;
            }
        }
        return null;
    }

    @Override
    public Client findByNIF(String nif) {

        Client client = null;

        for (int i = 0; i < clientList.size(); i++) {

            if (clientList.get(i).getNif().equals(nif)) {
                client = clientList.get(i);
                return client;
            }
        }
        return client;
    }

    @Override
    public void editClient(String nif, Client client) {

    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}