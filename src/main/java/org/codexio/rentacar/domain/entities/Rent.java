package org.codexio.rentacar.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rents")
public class Rent extends BaseEntity{
    
    private User owner;
    private User renter;
    private BigDecimal totalPrice;
    private LocalDateTime startDay;
    private LocalDateTime endDay;
    private Car car;

    public Rent() {
    }

    @Column(name = "owner", nullable = false)
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinTable(name = "rents_users"
            , joinColumns = @JoinColumn(name = "rent_id")
            , inverseJoinColumns = @JoinColumn(name = "user_id"))
    public User getRenter() {
        return renter;
    }

    public void setRenter(User renter) {
        this.renter = renter;
    }

    @Column(name = "total_price", nullable = false)
    @DecimalMin("0.01")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Column(name = "start_day")
    public LocalDateTime getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDateTime startDay) {
        this.startDay = startDay;
    }

    @Column(name = "end_day")
    public LocalDateTime getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDateTime endDay) {
        this.endDay = endDay;
    }

    @ManyToOne(targetEntity = Car.class)
    @JoinTable(name = "rents_cars"
            , joinColumns = @JoinColumn(name = "rent_id")
            , inverseJoinColumns = @JoinColumn(name = "car_id"))
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
