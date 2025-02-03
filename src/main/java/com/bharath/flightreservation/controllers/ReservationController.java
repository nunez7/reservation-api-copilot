package com.bharath.flightreservation.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.services.FlightService;

@Controller
public class ReservationController {

    private final FlightService flightService;

    public ReservationController(FlightService flightService) {
        this.flightService = flightService;
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
    
}
