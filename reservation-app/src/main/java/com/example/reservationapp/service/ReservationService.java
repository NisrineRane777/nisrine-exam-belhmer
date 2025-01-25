package com.example.reservationapp.service;

import com.example.reservationapp.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();
    Reservation createReservation(Reservation reservation);
}
