package com.capgemini.molveno.restaurant.Reservation.control;

import com.capgemini.molveno.restaurant.Reservation.model.Tablex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TableRepository extends JpaRepository<Tablex, Long>{
//public interface TableRepository extends CrudRepository<Tablex, Long> {

}
