package org.codexio.rentacar.service;

import org.codexio.rentacar.domain.models.service.CarServiceModel;

public interface CarService {

    public CarServiceModel createCar (CarServiceModel carServiceModel, String categoryName);
}
