package org.codexio.rentacar.config;

import org.codexio.rentacar.domain.entities.Car;
import org.codexio.rentacar.domain.models.binding.CarCreateBindingModel;
import org.codexio.rentacar.domain.models.binding.RentCreateBindingModel;
import org.codexio.rentacar.domain.models.service.CarServiceModel;
import org.codexio.rentacar.domain.models.service.RentServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationBeanConfiguration {
    
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        
        modelMapper.createTypeMap(
                CarCreateBindingModel.class,
                CarServiceModel.class
        ).addMapping(
                CarCreateBindingModel::getCategory,
                (dest, value)-> dest.setCategory((String) value)
        );

        modelMapper.createTypeMap(
                RentCreateBindingModel.class,
                RentServiceModel.class
        ).addMapping(
                RentCreateBindingModel::getStartDate,
                (dest, value)-> dest.setStartDay((String) value)
        ).addMapping(
                RentCreateBindingModel::getEndDate,
                (dest, value)-> dest.setEndDay((String) value)  
        );
        
        return modelMapper;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
