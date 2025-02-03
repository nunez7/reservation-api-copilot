package com.bharath.flightreservation.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bharath.flightreservation.dtos.ReservationRequest;
import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.services.FlightService;
import com.bharath.flightreservation.services.ReservationService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ReservationController {

    private final FlightService flightService;
    private final ReservationService reservationService;

    public ReservationController(FlightService flightService, ReservationService reservationService) {
        this.flightService = flightService;
        this.reservationService = reservationService;
    }

    @GetMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, Model model) {

        Optional<Flight> flight = flightService.getFlightById(flightId);    
        
        if (flight.isPresent()) {
            model.addAttribute("flight", flight.get());
            return "completeReservation";
        } else {
            model.addAttribute("msg", "Flight not found");
            return "noData";
        }
    }

    @PostMapping("/completeReservation")
    public String postMethodName(ReservationRequest request, Model model) {
        
        Reservation reservation = reservationService.bookFlight(request);
        model.addAttribute("msg", "Reservation created successfully with a reservation id: " + reservation.getId());
        model.addAttribute("reservation", reservation);
        
        return "reservationConfirmation";
    }
    
    
}
