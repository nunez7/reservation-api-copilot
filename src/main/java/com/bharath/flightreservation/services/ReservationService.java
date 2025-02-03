package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(Long id);
    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();
}