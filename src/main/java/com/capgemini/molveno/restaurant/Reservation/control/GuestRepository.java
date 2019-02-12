package com.capgemini.molveno.restaurant.Reservation.control;

import com.capgemini.molveno.restaurant.Reservation.model.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
