package org.codexio.rentacar.web.controllers;

import org.codexio.rentacar.domain.models.binding.CarCreateBindingModel;
import org.codexio.rentacar.domain.models.service.CarServiceModel;
import org.codexio.rentacar.domain.models.view.CarDetailsViewModel;
import org.codexio.rentacar.domain.models.view.CarMyAllViewModel;
import org.codexio.rentacar.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

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
        
        return redirect("/");
    }


    @GetMapping("/mine")
    public ModelAndView getMyCars(ModelAndView modelAndView, Principal principal){
        String username = principal.getName();
        List<CarMyAllViewModel> cars = this.carService.getMyCars(username)
                .stream()
                .map(c -> this.modelMapper.map(c, CarMyAllViewModel.class))
                .collect(Collectors.toList());
        modelAndView.addObject("cars", cars);
        
        return view("car/my-cars", modelAndView); 
    }
    
    @GetMapping("/details/{id}")
    public ModelAndView carDetails(@PathVariable String id, ModelAndView modelAndView){
        CarDetailsViewModel carDetailsViewModel = this.modelMapper
                .map(this.carService.findById(id), CarDetailsViewModel.class);
        modelAndView.addObject("car", carDetailsViewModel);
        
        return view("car/details", modelAndView);
    }
}
