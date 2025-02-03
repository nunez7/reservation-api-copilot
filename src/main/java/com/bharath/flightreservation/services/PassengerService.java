package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger savePassenger(Passenger passenger);
    Passenger updatePassenger(Passenger passenger);
    void deletePassenger(Long id);
    Passenger getPassengerById(Long id);
    List<Passenger> getAllPassengers();
}