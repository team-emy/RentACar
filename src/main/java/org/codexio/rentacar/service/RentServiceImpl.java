package org.codexio.rentacar.service;

import org.codexio.rentacar.domain.entities.Car;
import org.codexio.rentacar.domain.entities.Rent;
import org.codexio.rentacar.domain.entities.User;
import org.codexio.rentacar.domain.models.service.RentServiceModel;
import org.codexio.rentacar.repository.CarRepository;
import org.codexio.rentacar.repository.RentRepository;
import org.codexio.rentacar.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentServiceImpl implements RentService{
    
    private final RentRepository rentRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RentServiceImpl(RentRepository rentRepository, CarRepository carRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.rentRepository = rentRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RentServiceModel createRent(RentServiceModel rentServiceModel, String carId, String username) {
        Car car = this.carRepository.findById(carId).orElseThrow();
        User seller = car.getOwner();
        User buyer = this.userRepository.findByUsername(username).orElseThrow();
        
        Rent rent = this.modelMapper.map(rentServiceModel, Rent.class);
        rent.setSeller(seller);
        rent.setBuyer(buyer);
        rent.setStartDay(rentServiceModel.getStartDay());
        rent.setCar(car);
        
        this.rentRepository.save(rent);
        
        return this.modelMapper.map(rent, RentServiceModel.class);
    }
}
