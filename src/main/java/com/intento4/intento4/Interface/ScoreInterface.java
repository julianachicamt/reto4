package com.intento4.intento4.Interface;

import com.intento4.intento4.Modelo.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreInterface extends CrudRepository <Score, Integer> {
    
}
