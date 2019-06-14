package org.codexio.rentacar.service;

import org.codexio.rentacar.domain.entities.Car;
import org.codexio.rentacar.domain.entities.Category;
import org.codexio.rentacar.domain.entities.User;
import org.codexio.rentacar.domain.models.service.CarServiceModel;
import org.codexio.rentacar.repository.CarRepository;
import org.codexio.rentacar.repository.CategoryRepository;
import org.codexio.rentacar.repository.UserRepository;
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
    private final UserRepository userRepository;


    @Autowired
    public CarServiceImpl(ModelMapper modelMapper,
                          CarRepository carRepository,
                          CategoryRepository categoryRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CarServiceModel createCar(CarServiceModel carServiceModel, String username) {
        Category category = this.categoryRepository.findByName(carServiceModel.getCategory()).orElseThrow();
        User user = this.userRepository.findByUsername(username).orElseThrow();
        Car car = this.modelMapper.map(carServiceModel, Car.class);
        car.setCategory(category);
        car.setOwner(user);
        
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

    @Override
    public List<CarServiceModel> getMyCars(String username) {
        return this.carRepository.findAllByOwner(username)
                .stream()
                .map(c -> this.modelMapper.map(c, CarServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarServiceModel findById(String id) {
        Car car = this.carRepository.findById(id).orElseThrow();
        CarServiceModel carServiceModel = this.modelMapper
                .map(car, CarServiceModel.class);
        carServiceModel.setCategory(car.getCategory().getName());
        
        return carServiceModel;
    }


}
