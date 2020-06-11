package com.compasso.challenge.clients.models.client.repository;

import com.compasso.challenge.clients.models.client.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    public Client findByFullName(String fullName);
}
