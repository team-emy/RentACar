package org.codexio.rentacar.domain.models.view;
import java.math.BigDecimal;

public class CarHomeViewModel {

    private  String make;
    private String model;
    private String fuel;
    private String picture;
    private boolean isRented;
    private Boolean hasAC;
    private String transmission;
    private BigDecimal price;
    private String description;

    public CarHomeViewModel() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public Boolean getHasAC() {
        return hasAC;
    }

    public void setHasAC(Boolean hasAC) {
        this.hasAC = hasAC;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
