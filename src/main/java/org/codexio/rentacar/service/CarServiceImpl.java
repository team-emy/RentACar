package org.codexio.rentacar.service;

import org.codexio.rentacar.domain.entities.Car;
import org.codexio.rentacar.domain.entities.Category;
import org.codexio.rentacar.domain.models.service.CarServiceModel;
import org.codexio.rentacar.repository.CarRepository;
import org.codexio.rentacar.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final CategoryRepository categoryRepository;


    @Autowired
    public CarServiceImpl(ModelMapper modelMapper,
                          CarRepository carRepository,
                          CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CarServiceModel createCar(CarServiceModel carServiceModel, String categoryName) {
        Car car = this.modelMapper.map(carServiceModel, Car.class);
        Category category = this.categoryRepository.findByName(categoryName).orElseThrow();
        car.setCategory(category);
        this.carRepository.save(car);

        return carServiceModel;
    }

    @Override
    public List<CarServiceModel> findAllCars() {
        return this.carRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CarServiceModel.class))
                .collect(Collectors.toList());
    }


}
