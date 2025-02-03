package com.bharath.flightreservation.services;


import com.bharath.flightreservation.entities.Flight;

import java.util.List;

public interface FlightService {
    Flight saveFlight(Flight flight);
    Flight updateFlight(Flight flight);
    void deleteFlight(Long id);
    Flight getFlightById(Long id);
    List<Flight> getAllFlights();
}
