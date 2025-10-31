package com.southernbites.SouthernBitesApplication.repository;

import com.southernbites.SouthernBitesApplication.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
