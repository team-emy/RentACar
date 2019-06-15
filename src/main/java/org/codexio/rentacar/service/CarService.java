package org.codexio.rentacar.service;

import org.codexio.rentacar.domain.models.service.CarServiceModel;

import java.util.List;

public interface CarService {

    public CarServiceModel createCar (CarServiceModel carServiceModel, String username);

    public List<CarServiceModel> findAllCars();
    
    List<CarServiceModel> getMyCars(String username);
    
    CarServiceModel findById(String id);

    CarServiceModel editCar (CarServiceModel carServiceModel, String username, String carId);


    List<CarServiceModel> findAllCarsByCategory(String category);

    public void deleteCar(String id);
}
