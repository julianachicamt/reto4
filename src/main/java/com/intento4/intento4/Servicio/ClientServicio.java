package com.intento4.intento4.Servicio;

import com.intento4.intento4.Modelo.Client;
import com.intento4.intento4.Repositorio.ClientRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientServicio {
    @Autowired
    private ClientRepositorio clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int clientId) {
        return clientRepository.getClient(clientId);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> e= clientRepository.getClient(client.getIdClient());
            if(e.isPresent()){
                return client;
            }else{
                return clientRepository.save(client);
            }
        }
    } 

     public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= clientRepository.getClient(client.getIdClient());
            if(e.isPresent()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                clientRepository.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
        
     public boolean deleteClient (int id){
        Boolean d = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }
}
