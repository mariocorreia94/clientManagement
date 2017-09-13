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

    //All Clients
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<Client>> findAll() {

        return ResponseEntity.ok().body(clientServiceImp.findAll());

    }

    //findByName Clients
    @RequestMapping(method = RequestMethod.GET, value = "/name/")
    public ResponseEntity<List<Client>> findByName(@RequestParam(name = "name") String name) {

        return ResponseEntity.ok().body(clientServiceImp.findByName(name));
    }

    //Add Client
    @RequestMapping(method = RequestMethod.POST, value = "/add", consumes = "application/json")
    public ResponseEntity createClient(@RequestBody Client client) {

        if (clientServiceImp.findByNIF(client.getNif()) == null) {

            clientServiceImp.addClient(client);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //Search by NIF
    @RequestMapping(method = RequestMethod.GET, value = "/search/")
    public ResponseEntity<Client> getClient(@RequestParam(name = "nif") String nif) {

        if (clientServiceImp.findByNIF(nif) != null) {
            return ResponseEntity.ok(clientServiceImp.findByNIF(nif));
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a client
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/")
    public ResponseEntity deleteClient(@RequestParam(name = "nif") String nif) {

        if (clientServiceImp.findByNIF(nif) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clientServiceImp.removeClient(nif);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/edit/", consumes = "application/json")
    public ResponseEntity editClient(@RequestParam(name = "nif") String nif, @RequestBody Client client){

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