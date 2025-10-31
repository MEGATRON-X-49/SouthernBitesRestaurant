package com.southernbites.SouthernBitesApplication.service;

import com.southernbites.SouthernBitesApplication.model.Reservation;
import com.southernbites.SouthernBitesApplication.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository repo;

    public ReservationService(ReservationRepository repo) {
        this.repo = repo;
    }

    public Reservation save(Reservation reservation) {
        return repo.save(reservation);
    }

    public List<Reservation> findAll() {
        return repo.findAll();
    }
}
