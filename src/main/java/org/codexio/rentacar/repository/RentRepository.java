package org.codexio.rentacar.repository;

import org.codexio.rentacar.domain.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, String> {

    @Query("SELECT r FROM Rent r WHERE r.seller.username = :username")
    List<Rent> findAllMyRents(@Param("username") String username);


    @Query("SELECT r FROM Rent r WHERE r.buyer.username = :username")
    List<Rent> findAllRentsToBuyer(@Param("username") String username);

    @Query("SELECT r FROM Rent r WHERE r.car.id = :id")
    List<Rent> findAllRentsToCar(@Param("id") String id);
}
