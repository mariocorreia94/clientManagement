package management.client.controller;

import management.client.model.Client;
import management.client.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/service/users")
public class ClientRestController {

    ClientService clientServiceImp;

    //Serach Clients
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<Client>> findClients(@RequestParam(name = "name", required = false) String name) {

        if (name == null) {
            return ResponseEntity.ok().body(clientServiceImp.findAll());
        }
        return ResponseEntity.ok().body(clientServiceImp.findByName(name));
    }

    //Search by NIF
    @RequestMapping(method = RequestMethod.GET, value = "/{nif}")
    public ResponseEntity<Client> getClient(@PathVariable String nif) {

        if (clientServiceImp.findByNIF(nif) != null) {
            return ResponseEntity.ok(clientServiceImp.findByNIF(nif));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete Client
    @RequestMapping(method = RequestMethod.DELETE, value = "/{nif}")
    public ResponseEntity deleteClient(@PathVariable String nif) {

        if (clientServiceImp.findByNIF(nif) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clientServiceImp.removeClient(nif);

        return ResponseEntity.noContent().build();
    }

    //Add Client
    @RequestMapping(method = RequestMethod.POST, value = "/", consumes = "application/json")
    public ResponseEntity createClient(@RequestBody Client client) {

        if (clientServiceImp.findByNIF(client.getNif()) == null) {

            clientServiceImp.addClient(client);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //Edit Client
    @RequestMapping(method = RequestMethod.PUT, value = "/{nif}", consumes = "application/json")
    public ResponseEntity editClient(@PathVariable String nif, @RequestBody Client client) {

        if (clientServiceImp.findByNIF(nif) == null || client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clientServiceImp.editClient(nif, client);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Resource
    public void setClientServiceImp(ClientService clientServiceImp) {
        this.clientServiceImp = clientServiceImp;
    }
}