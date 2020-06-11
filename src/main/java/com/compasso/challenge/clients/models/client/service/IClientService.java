package com.compasso.challenge.clients.models.client.service;

import com.compasso.challenge.clients.models.client.entity.Client;

import java.util.List;

public interface IClientService {

    List<Client> listAllClients();

    Client getClientById(Integer id);

    Client saveClient(Client client);

    void deleteClient(Integer id);

    Client findByFullName(String name);
}
