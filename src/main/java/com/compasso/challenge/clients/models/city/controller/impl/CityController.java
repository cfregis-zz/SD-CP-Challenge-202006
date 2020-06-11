package com.compasso.challenge.clients.models.city.controller.impl;

import com.compasso.challenge.clients.models.city.controller.ICityController;
import com.compasso.challenge.clients.models.city.entity.City;
import com.compasso.challenge.clients.models.city.service.ICityService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@Api(value="clientplatform", description="Operations pertaining to cities in client platform")
public class CityController implements ICityController {

    private ICityService cityService;

    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @ApiOperation(value = "View a list of available cities",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    @Override
    public List<City> list() {
        return cityService.listAllCities();
    }

    @ApiOperation(value = "Search a City with an ID",response = City.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    @Override
    public City getById(@PathVariable Integer id) {
        return cityService.getCityById(id);
    }

    @ApiOperation(value = "Add a City")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @Override
    public City add(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    @ApiOperation(value = "Update a City")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    @Override
    public City update(@PathVariable Integer id, @RequestBody City city) {
        return cityService.saveCity(city);
    }

    @ApiOperation(value = "Delete a City")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @Override
    public ResponseEntity<City> delete(@PathVariable Integer id) {
        cityService.deleteCity(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available cities by name",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/list/name/{name}", method= RequestMethod.GET, produces = "application/json")
    @Override
    public List<City> findByName(@PathVariable(name = "name") String name) {
        return cityService.findByName(name);
    }

    @ApiOperation(value = "View a list of available cities by state",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/list/state/{state}", method= RequestMethod.GET, produces = "application/json")
    @Override
    public List<City> findByState(@PathVariable(name = "state") String state) {
        return cityService.findByState(state);
    }
}
