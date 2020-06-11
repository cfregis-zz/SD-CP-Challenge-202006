package com.compasso.challenge.clients.models.client.entity;

import com.compasso.challenge.clients.foundation.entity.AbstractModel;
import com.compasso.challenge.clients.models.city.entity.City;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client extends AbstractModel {

    private String fullName;

    private String gender;

    private String birthday;

    private Integer age;

    @JoinColumn(name="client_city", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CLIENT_CITY"))
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = City.class)
    private City city;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
