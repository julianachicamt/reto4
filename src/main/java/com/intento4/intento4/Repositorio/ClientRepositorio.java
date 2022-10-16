package com.intento4.intento4.Repositorio;

import com.intento4.intento4.Interface.ClientInterface;
import com.intento4.intento4.Modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class ClientRepositorio {
    @Autowired
    private ClientInterface clientCrudRepository;
    
      public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
     
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
}
