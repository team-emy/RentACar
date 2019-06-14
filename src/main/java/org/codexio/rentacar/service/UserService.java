package org.codexio.rentacar.service;

import org.codexio.rentacar.domain.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    
    public UserServiceModel register(UserServiceModel userServiceModel);
}
