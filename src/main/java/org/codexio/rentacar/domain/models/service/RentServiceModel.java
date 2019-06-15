package org.codexio.rentacar.domain.models.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentServiceModel {
    
    private UserServiceModel seller;
    private UserServiceModel buyer;
    private BigDecimal totalPrice;
    private String startDay;
    private String endDay;
    private CarServiceModel car;

    public RentServiceModel() {
    }

    public UserServiceModel getSeller() {
        return seller;
    }

    public void setSeller(UserServiceModel seller) {
        this.seller = seller;
    }

    public UserServiceModel getBuyer() {
        return buyer;
    }

    public void setBuyer(UserServiceModel buyer) {
        this.buyer = buyer;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public CarServiceModel getCar() {
        return car;
    }

    public void setCar(CarServiceModel car) {
        this.car = car;
    }
}
