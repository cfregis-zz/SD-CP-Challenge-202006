/**
 * 
 */
package com.compasso.challenge.clients.foundation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICRUDController<T> {
	List<T> list();

    T getById(@PathVariable Integer id);

    T add(T domainObject);
    
    T update(Integer id, T domainObject);

    ResponseEntity<T> delete(Integer id);
}
