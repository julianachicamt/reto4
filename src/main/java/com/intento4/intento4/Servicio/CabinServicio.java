package com.intento4.intento4.Servicio;

import com.intento4.intento4.Modelo.Cabin;
import com.intento4.intento4.Repositorio.CabinRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class CabinServicio {
    @Autowired
    private CabinRepositorio cabinRepository;

    public List<Cabin> getAll(){
        return cabinRepository.getAll();
    }

    public Optional<Cabin> getCabin(int cabinId) {
        return cabinRepository.getCabin(cabinId);
    }

    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return cabinRepository.save(cabin);
        }else{
            Optional<Cabin>e= cabinRepository.getCabin(cabin.getId());
            if(e.isPresent()){
                return cabin;
            }else{
                return cabinRepository.save(cabin);
            }
        }
    }
    
       public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin> e= cabinRepository.getCabin(cabin.getId());
            if(e.isPresent()){
                if(cabin.getName()!=null){
                    e.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    e.get().setBrand(cabin.getBrand());
                }
                if(cabin.getRooms()!=null){
                    e.get().setRooms(cabin.getRooms());
                }
                if(cabin.getDescription()!=null){
                    e.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    e.get().setCategory(cabin.getCategory());
                }
                cabinRepository.save(e.get());
                return e.get();
            }else{
                return cabin;
            }
        }else{
            return cabin;
        }
    }

    
    
      public boolean deleteCabin (int id){
        Boolean d = getCabin(id).map(cabin -> {
            cabinRepository.delete(cabin);
            return true;
        }).orElse(false);
        return d;
    }
}
