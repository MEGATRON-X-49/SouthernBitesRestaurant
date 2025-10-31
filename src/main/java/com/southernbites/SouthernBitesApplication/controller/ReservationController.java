package com.southernbites.SouthernBitesApplication.controller;

import com.southernbites.SouthernBitesApplication.model.Reservation;
import com.southernbites.SouthernBitesApplication.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Display booking form
    @GetMapping("/booking")
    public String showBookingForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "booking";
    }

    // Handle booking form submission with server-side validation
    @PostMapping("/booking")
    public String submitBooking(@Valid @ModelAttribute("reservation") Reservation reservation,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            // errors are available in the template via th:errors
            return "booking";
        }
        reservationService.save(reservation);
        model.addAttribute("successMessage", "Reservation submitted successfully!");
        // reset the form
        model.addAttribute("reservation", new Reservation());
        return "booking";
    }
}
