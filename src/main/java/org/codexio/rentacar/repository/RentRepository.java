package org.codexio.rentacar.repository;

import org.codexio.rentacar.domain.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, String> {
}
