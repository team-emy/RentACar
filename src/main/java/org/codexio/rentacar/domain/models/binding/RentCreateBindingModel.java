package org.codexio.rentacar.domain.models.binding;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentCreateBindingModel {
    
    private String totalPrice;
    private String startDate;
    private String endDate;

    public RentCreateBindingModel() {
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
