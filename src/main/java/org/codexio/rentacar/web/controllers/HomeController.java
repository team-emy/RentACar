package org.codexio.rentacar.web.controllers;

import org.codexio.rentacar.domain.models.view.CarHomeViewModel;
import org.codexio.rentacar.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController extends BaseController {
    private final CarService carService;
    private final ModelMapper modelMapper;

    public HomeController(CarService carService, ModelMapper modelMapper) {
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        List<CarHomeViewModel> cars= this.carService.findAllCars()
                    .stream()
                    .map(carServiceModel -> this.modelMapper.map(carServiceModel, CarHomeViewModel.class))
                    .collect(Collectors.toList());
        

        modelAndView.addObject("cars", cars);

        return view("index", modelAndView);
    }

    @GetMapping("/category/{name}")
    public ModelAndView index(ModelAndView modelAndView, @PathVariable String name){
        List<CarHomeViewModel> cars = this.carService.findAllCarsByCategory(name)
                .stream()
                .map(carServiceModel -> this.modelMapper.map(carServiceModel, CarHomeViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("cars", cars);

        return view("index", modelAndView);
    }

}
