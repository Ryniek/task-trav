package com.travactory.recruitment.junior.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travactory.recruitment.junior.model.Airport;

public interface AirportsRepository extends JpaRepository<Airport, Integer> {
	Optional<Airport> findByCode(String code);
}
