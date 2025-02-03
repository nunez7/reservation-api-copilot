package com.bharath.flightreservation.services;


import com.bharath.flightreservation.entities.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {
    Flight saveFlight(Flight flight);
    Flight updateFlight(Flight flight);
    void deleteFlight(Long id);
    Flight getFlightById(Long id);
    List<Flight> getAllFlights();
    List<Flight> findFlights(String from, 
                             String to, 
                             Date departureDate);
}
