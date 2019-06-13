package org.codexio.rentacar.web.controllers;

import org.codexio.rentacar.domain.models.binding.UserRegisterBindingModel;
import org.codexio.rentacar.domain.models.service.UserServiceModel;
import org.codexio.rentacar.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{
    
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return view("authentication/login");
    }
    
    @GetMapping("/register")
    public ModelAndView register(
            ModelAndView modelAndView,
            @ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel
    ) {

        modelAndView.addObject("userRegisterBindingModel", userRegisterBindingModel);
        
        return view("authentication/register");
    }
    
    @PostMapping("/register")
    public ModelAndView registerConfirm(
            ModelAndView modelAndView,
            @ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel
    ){
        if (!userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {

            return redirect("/register");
        }

        UserServiceModel model = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
        this.userService.register(model);
        
        return redirect("/login");
    }

    
    
}
