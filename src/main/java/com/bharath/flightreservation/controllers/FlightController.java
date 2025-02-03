package com.bharath.flightreservation.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;

import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.services.FlightService;


@Controller
public class FlightController {

    private final FlightService flightService;

    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);


    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/findFlights")
    public String displayFindFlights() {
        return "findFlights";
    }

    @PostMapping("/findFlights")
    public String findFlights(@RequestParam("from") String from,
                              @RequestParam("to") String to,
                              @RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
                              Model model) {
        logger.info("Searching for flights from {} to {} on {}", from, to, departureDate);
        
        List<Flight> flights = flightService.findFlights(from, to, departureDate);

        if(flights.isEmpty()) {
            logger.warn("No flights found from {} to {} on {}", from, to, departureDate);
            model.addAttribute("msg", "No flights found");
            return "noData";
        }
        
        model.addAttribute("flights", flights);
        return "displayFlights";
        
    }
}