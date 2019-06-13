package org.codexio.rentacar.service;

import org.codexio.rentacar.domain.models.service.CarServiceModel;

import java.util.List;

public interface CarService {

    public CarServiceModel createCar (CarServiceModel carServiceModel, String categoryName);

    public List<CarServiceModel> findAllCars();

}
