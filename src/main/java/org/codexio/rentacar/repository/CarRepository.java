package org.codexio.rentacar.repository;

import org.codexio.rentacar.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,String> {
}
