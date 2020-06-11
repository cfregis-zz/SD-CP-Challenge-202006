package com.compasso.challenge.clients.models.city.service.impl;

import com.compasso.challenge.clients.models.city.entity.City;
import com.compasso.challenge.clients.models.city.repository.CityRepository;
import com.compasso.challenge.clients.models.city.service.ICityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @Override
    public List<City> listAllCities() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public City getCityById(Integer id) {
        Optional<City> city = cityRepository.findById(id);
        return city.get();
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<City> findByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public List<City> findByState(String state) {
        return cityRepository.findByState(state);
    }
}
