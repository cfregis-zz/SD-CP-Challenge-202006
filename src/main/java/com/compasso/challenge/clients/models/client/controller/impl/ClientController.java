package com.compasso.challenge.clients.models.client.controller.impl;

import com.compasso.challenge.clients.models.city.entity.City;
import com.compasso.challenge.clients.models.client.controller.IClientController;
import com.compasso.challenge.clients.models.client.entity.Client;
import com.compasso.challenge.clients.models.client.service.IClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@Api(value="clientplatform", description="Operations pertaining to clients in client platform")
public class ClientController implements IClientController {

    public IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @ApiOperation(value = "View a list of available clients by fullname",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/list/name/{name}", method= RequestMethod.GET, produces = "application/json")
    @Override
    public Client findByFullName(@PathVariable(name = "name") String name) {
        return clientService.findByFullName(name);
    }

    @ApiOperation(value = "View a list of available clients by fullname",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    @Override
    public List<Client> list() {
        return clientService.listAllClients();
    }

    @ApiOperation(value = "Search a Client with an ID",response = City.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    @Override
    public Client getById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @ApiOperation(value = "Add a Client")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @Override
    public Client add(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @ApiOperation(value = "Update a Client")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    @Override
    public Client update(@PathVariable Integer id, @RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @ApiOperation(value = "Delete a Client")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @Override
    public ResponseEntity<Client> delete(@PathVariable Integer id) {
        clientService.deleteClient(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
