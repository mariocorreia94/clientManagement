package management.client.model;

import management.client.model.Client;
import management.client.model.HibernateClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HibernateClientTest {

    public static final String nif = "123456789";

    private HibernateClient hibernateClient;

    private Client c1;
    private Client c2;


    @Before
    public void setUp() throws Exception {

        hibernateClient = Mockito.mock(HibernateClient.class);

        c1 = Mockito.mock(Client.class);
        c2 = Mockito.mock(Client.class);

        hibernateClient = new HibernateClient();
    }

    @Test
    public void createClient() {

    }

    @Test
    public void deleteClient(){

    }

    @Test
    public void searchClientByNIF(){

    }

    @Test
    public void searchClientByName(){

    }

    @Test
    public void searchAllClients(){

    }

}
