package com.compasso.challenge.clients.models.city.entity;

import com.compasso.challenge.clients.foundation.entity.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City extends AbstractModel {

    private String name;

    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
