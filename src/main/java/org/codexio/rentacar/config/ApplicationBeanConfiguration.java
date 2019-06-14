package org.codexio.rentacar.config;

import org.codexio.rentacar.domain.entities.Car;
import org.codexio.rentacar.domain.models.binding.CarCreateBindingModel;
import org.codexio.rentacar.domain.models.service.CarServiceModel;
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
        return new ModelMapper();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
