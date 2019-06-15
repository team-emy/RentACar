package org.codexio.rentacar.web.controllers;

import org.codexio.rentacar.domain.models.binding.RentCreateBindingModel;
import org.codexio.rentacar.domain.models.service.RentServiceModel;
import org.codexio.rentacar.service.RentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/rents")
public class RentController extends BaseController {
    
    private final RentService rentService;
    private final ModelMapper modelMapper;

    @Autowired
    public RentController(RentService rentService, ModelMapper modelMapper) {
        this.rentService = rentService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/my/{id}")
    public ModelAndView createRent(@PathVariable String id, 
                                   Principal principal, 
                                   RentCreateBindingModel rentCreateBindingModel) {
        String username = principal.getName();
        RentServiceModel model = this.modelMapper.map(rentCreateBindingModel, RentServiceModel.class);
        this.rentService.createRent(model, id, username);
        
        return redirect("/");
    }
    
}
