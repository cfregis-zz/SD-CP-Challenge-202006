package com.compasso.challenge.clients.models.client.controller;

import com.compasso.challenge.clients.foundation.controller.ICRUDController;
import com.compasso.challenge.clients.models.city.entity.City;
import com.compasso.challenge.clients.models.client.entity.Client;

import java.util.List;

public interface IClientController  extends ICRUDController<Client> {

    Client findByFullName(String name);

}
