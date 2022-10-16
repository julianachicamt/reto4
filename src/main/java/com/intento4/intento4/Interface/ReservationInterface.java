package com.intento4.intento4.Interface;

import com.intento4.intento4.Modelo.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationInterface extends CrudRepository <Reservation, Integer> {
    
}
