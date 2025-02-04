package com.bharath.flightreservation.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.flightreservation.dtos.ReservationUpdateRequest;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.services.ReservationService;

@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins = "http://localhost:4200") // Allow this origin
public class ReservationRestController {

	private final ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

	@GetMapping("/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		return reservationService.getReservationById(id);

	}

	@PostMapping
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationService.getReservationById(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationService.saveReservation(reservation);

	}

}
