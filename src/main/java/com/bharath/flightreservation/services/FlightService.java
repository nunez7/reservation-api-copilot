package com.bharath.flightreservation.services;


import com.bharath.flightreservation.entities.Flight;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    Flight saveFlight(Flight flight);
    Flight updateFlight(Flight flight);
    void deleteFlight(Long id);
    Optional<Flight> getFlightById(Long id);
    List<Flight> getAllFlights();
    List<Flight> findFlights(String from, 
                             String to, 
                             Date departureDate);
}
