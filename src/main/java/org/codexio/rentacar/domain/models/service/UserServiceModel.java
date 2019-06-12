package org.codexio.rentacar.domain.models.service;


import org.codexio.rentacar.domain.entities.Car;
import org.codexio.rentacar.domain.entities.Rent;
import org.codexio.rentacar.domain.entities.Role;

import java.util.List;
import java.util.Set;
public class UserServiceModel {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Rent> myRents;
    private List<Car> myCars;
    private List<Car> renterCars;

    private Set<Role> authorities;

    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rent> getMyRents() {
        return myRents;
    }

    public void setMyRents(List<Rent> myRents) {
        this.myRents = myRents;
    }

    public List<Car> getMyCars() {
        return myCars;
    }

    public void setMyCars(List<Car> myCars) {
        this.myCars = myCars;
    }

    public List<Car> getRenterCars() {
        return renterCars;
    }

    public void setRenterCars(List<Car> renterCars) {
        this.renterCars = renterCars;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }
}
