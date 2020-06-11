package com.compasso.challenge.clients.models.city.service;

import com.compasso.challenge.clients.models.city.entity.City;

import java.util.List;

public interface ICityService {

    List<City> listAllCities();

    City getCityById(Integer id);

    City saveCity(City city);

    void deleteCity(Integer id);

    List<City> findByName(String name);

    List<City> findByState(String state);
}
