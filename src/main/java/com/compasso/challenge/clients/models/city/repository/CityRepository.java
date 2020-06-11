package com.compasso.challenge.clients.models.city.repository;

import com.compasso.challenge.clients.models.city.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer> {

    public List<City> findByName(String name);

    public List<City> findByState(String state);
}
