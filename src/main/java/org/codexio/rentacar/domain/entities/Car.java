package org.codexio.rentacar.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    
    private String make;
    private String model;
    private String year;
    private String fuel;
    private String fuelConsumption;
    private Double horsepower;
    private String picture;
    private User owner;
    private boolean isRented;
    private Boolean hasAC;
    private String transmission;
    private Integer doors;
    private Integer passengers;
    private BigDecimal price;
    private String description;
    private Category category;
    private List<User> renters;
    private List<Rent> rents;

    public Car() {
        this.renters = new ArrayList<>();
        this.rents = new ArrayList<>();
    }

    @Column(name = "make", nullable = false)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "year", nullable = false)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Column(name = "fuel", nullable = false)
    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Column(name = "fuel_consumption", nullable = false)
    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Column(name = "horsepower", nullable = false)
    public Double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Double horsepower) {
        this.horsepower = horsepower;
    }

    @Column(name = "picture", nullable = false)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinTable(name = "cars_users"
            , joinColumns = @JoinColumn(name = "car_id")
            , inverseJoinColumns = @JoinColumn(name = "user_id"))
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Column(name = "is_rented", nullable = false, columnDefinition = "false")
    public boolean getRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Column(name = "has_AC")
    public Boolean getHasAC() {
        return hasAC;
    }

    public void setHasAC(Boolean hasAC) {
        this.hasAC = hasAC;
    }

    @Column(name = "transmission", nullable = false)
    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Column(name = "doors", nullable = false)
    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    @Column(name = "passengers", nullable = false)
    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    @Column(name = "price", nullable = false)
    @DecimalMin("0.01")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(targetEntity = Category.class)
    @JoinTable(name = "cars_categories"
            , joinColumns = @JoinColumn(name = "car_id")
            , inverseJoinColumns = @JoinColumn(name = "category_id"))
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToMany(targetEntity = User.class )
    @JoinTable(
            name = "renter_cars_users",
            joinColumns = @JoinColumn(
                    name = "car_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            )
    )
    public List<User> getRenters() {
        return renters;
    }

    public void setRenters(List<User> renters) {
        this.renters = renters;
    }

    @OneToMany(targetEntity = Rent.class, mappedBy = "car")
    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
