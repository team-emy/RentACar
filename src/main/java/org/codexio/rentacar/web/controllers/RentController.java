package org.codexio.rentacar.web.controllers;

import org.codexio.rentacar.domain.models.binding.RentCreateBindingModel;
import org.codexio.rentacar.domain.models.service.RentServiceModel;
import org.codexio.rentacar.domain.models.view.RentViewModel;
import org.codexio.rentacar.service.RentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

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
    
    @GetMapping("/fromme")
    public ModelAndView getMyRents(Principal principal, ModelAndView modelAndView){
        String username = principal.getName();
        List<RentViewModel> rentServiceModels = this.rentService.getRentsByMe(username)
                .stream()
                .map(r -> {
                   String usernameBuyer = r.getSeller().getUsername();
                   String startDate = r.getStartDay();
                   String endDate = r.getEndDay();

                    RentViewModel r2 = this.modelMapper.map(r, RentViewModel.class);
                   
                   r2.setStartDate(startDate);
                   r2.setEndDate(endDate);
                   r2.setUser(usernameBuyer);
                   
                   return r2;
                } ) .collect(Collectors.toList());
        
        
        modelAndView.addObject("rents",rentServiceModels );
        return view("rent/rent-mine" , modelAndView);
    }


    @GetMapping("/byme")
    public ModelAndView getRentsByMe(Principal principal, ModelAndView modelAndView){
        String username = principal.getName();
        List<RentViewModel> rentServiceModels = this.rentService.findAllMyRents(username)
                .stream()
                .map(r -> {
                    String usernameBuyer = r.getBuyer().getUsername();
                    String startDate = r.getStartDay();
                    String endDate = r.getEndDay();

                    RentViewModel r2 = this.modelMapper.map(r, RentViewModel.class);

                    r2.setStartDate(startDate);
                    r2.setEndDate(endDate);
                    r2.setUser(usernameBuyer);

                    return r2;
                } ) .collect(Collectors.toList());


        modelAndView.addObject("rents",rentServiceModels );
        return view("rent/rent-mine" , modelAndView);
    }
}
