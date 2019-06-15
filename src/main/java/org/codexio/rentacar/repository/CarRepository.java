package org.codexio.rentacar.repository;

import org.codexio.rentacar.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,String> {
    
    Optional<Car> findById(String id );
    
    List<Car> findAll();

    @Query("SELECT c FROM Car c WHERE c.owner.username = :username")
    List<Car> findAllByOwner(@Param("username") String username);

    @Query("SELECT c FROM Car c WHERE c.category.name = :name")
    List<Car> findAllByCategory(@Param("name") String name);
}
