package org.codexio.rentacar.repository;

import org.codexio.rentacar.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,String> {
    List<Car> findAll();
}
