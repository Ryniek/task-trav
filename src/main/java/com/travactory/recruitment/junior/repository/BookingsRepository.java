package com.travactory.recruitment.junior.repository;

import com.travactory.recruitment.junior.model.Booking;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<Booking, Integer> {
	Optional<Booking> findById(Integer id);
}
