package com.compasso.challenge.clients.models.city.controller;

import com.compasso.challenge.clients.foundation.controller.ICRUDController;
import com.compasso.challenge.clients.models.city.entity.City;

import java.util.List;

public interface ICityController extends ICRUDController<City> {

    List<City> findByName(String name);

    List<City> findByState(String state);
}
