package com.intento4.intento4.Interface;

import com.intento4.intento4.Modelo.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageInterface extends CrudRepository <Message, Integer> {
    
}
