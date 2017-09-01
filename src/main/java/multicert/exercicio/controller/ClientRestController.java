package multicert.exercicio.controller;

import multicert.exercicio.model.Client;
import multicert.exercicio.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/service/users")
public class ClientRestController {


    ClientService clientServiceImp;

    //All Clients and findByName Clients
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<Client>> findByName(@RequestParam(name = "name", required = false) String name) {

        return ResponseEntity.ok().body(clientServiceImp.findByName(name));
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

    //Search by NIF
    @RequestMapping(method = RequestMethod.GET, value = "/{nif}")
    public ResponseEntity<Client> getClient(@PathVariable String nif) {

        if (clientServiceImp.findByNIF(nif) != null) {
            return ResponseEntity.ok(clientServiceImp.findByNIF(nif));
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{nif}")
    public ResponseEntity deleteClient(@PathVariable String nif) {

        if (clientServiceImp.findByNIF(nif) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clientServiceImp.removeClient(nif);

        return ResponseEntity.noContent().build();
    }

    @Resource
    public void setClientServiceImp(ClientService clientServiceImp) {
        this.clientServiceImp = clientServiceImp;
    }
}