package com.intento4.intento4.Interface;

import com.intento4.intento4.Modelo.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminInterface extends CrudRepository <Admin, Integer>  {
    
}
