package com.intento4.intento4.Interface;

import com.intento4.intento4.Modelo.Cabin;
import org.springframework.data.repository.CrudRepository;

public interface CabinInterface extends CrudRepository <Cabin, Integer> {
    
}
