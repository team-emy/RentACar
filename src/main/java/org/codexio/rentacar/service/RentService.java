package org.codexio.rentacar.service;

import org.codexio.rentacar.domain.models.service.RentServiceModel;
public interface RentService {
    RentServiceModel createRent(RentServiceModel rentServiceModel, String carId, String username);
}
