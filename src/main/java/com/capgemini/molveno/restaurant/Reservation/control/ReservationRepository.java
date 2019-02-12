package com.capgemini.molveno.restaurant.Reservation.control;

import com.capgemini.molveno.restaurant.Reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
