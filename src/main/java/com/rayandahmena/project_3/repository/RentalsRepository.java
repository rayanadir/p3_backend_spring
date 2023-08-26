package com.rayandahmena.project_3.repository;

import com.rayandahmena.project_3.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends JpaRepository<Rental,Integer> {
}
