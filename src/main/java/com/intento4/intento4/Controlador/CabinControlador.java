package com.intento4.intento4.Controlador;

import com.intento4.intento4.Modelo.Cabin;
import com.intento4.intento4.Servicio.CabinServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*")

public class CabinControlador {
    @Autowired
    private CabinServicio cabinService;
    @GetMapping("/all")
    public List<Cabin> getCabins(){
        return cabinService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cabin> getCabin(@PathVariable("id") int cabinId) {
        return cabinService.getCabin(cabinId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin) {
        return cabinService.save(cabin);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin) {
        return cabinService.update(cabin);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return cabinService.deleteCabin(id);
    }
    
  
}
