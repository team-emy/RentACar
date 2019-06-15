package org.codexio.rentacar.service;

import org.codexio.rentacar.domain.models.service.RentServiceModel;

import java.util.List;
public interface RentService {
    
    RentServiceModel createRent(RentServiceModel rentServiceModel, String carId, String username);
    
    List<RentServiceModel> findAllMyRents(String myUsername);
    
    List<RentServiceModel> getRentsByMe(String myUsername);
}
