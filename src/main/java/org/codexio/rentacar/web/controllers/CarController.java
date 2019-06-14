package org.codexio.rentacar.web.controllers;

import org.codexio.rentacar.domain.models.binding.CarCreateBindingModel;
import org.codexio.rentacar.domain.models.service.CarServiceModel;
import org.codexio.rentacar.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/cars")
public class CarController extends BaseController {

    private final ModelMapper modelMapper;
    private final CarService carService;


    public CarController(ModelMapper modelMapper, CarService carService) {
        this.modelMapper = modelMapper;
        this.carService = carService;
    }


    @GetMapping("/create")
    public ModelAndView createCar() {

        return view("car/create-car");
    }

    @PostMapping("/create")
    public ModelAndView createCar(CarCreateBindingModel carCreateBindingModel, Principal principal) {
        String username = principal.getName();
        CarServiceModel carServiceModel = this.modelMapper.map(carCreateBindingModel, CarServiceModel.class);
        this.carService.createCar(carServiceModel, username);
        
        return view("car/create-car");
    }




}
