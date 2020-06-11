package com.compasso.challenge.clients.models.client.service.impl;

import com.compasso.challenge.clients.models.city.repository.CityRepository;
import com.compasso.challenge.clients.models.client.entity.Client;
import com.compasso.challenge.clients.models.client.repository.ClientRepository;
import com.compasso.challenge.clients.models.client.service.IClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> listAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client getClientById(Integer id) {
        Optional<Client> client =  clientRepository.findById(id);
        return client.get();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client findByFullName(String name) {
        return clientRepository.findByFullName(name);
    }
}
