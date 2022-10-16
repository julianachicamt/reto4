package com.intento4.intento4.Repositorio;

import com.intento4.intento4.Interface.CabinInterface;
import com.intento4.intento4.Modelo.Cabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CabinRepositorio {
    

    @Autowired
    private CabinInterface cabinCrudRepository;
    
      public List<Cabin> getAll(){
        return (List<Cabin>) cabinCrudRepository.findAll();
    }
    
    public Optional<Cabin> getCabin(int id){
        return cabinCrudRepository.findById(id);
    }

    public Cabin save(Cabin cabin){
        return cabinCrudRepository.save(cabin);
    }
    
     public void delete(Cabin cabin){
        cabinCrudRepository.delete(cabin);
    }
}
