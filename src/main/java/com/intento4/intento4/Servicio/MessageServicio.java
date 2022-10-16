package com.intento4.intento4.Servicio;

import com.intento4.intento4.Modelo.Message;
import com.intento4.intento4.Repositorio.MessageRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class MessageServicio {
    @Autowired
    private MessageRepositorio messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return messageRepository.getMessage(messageId);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> e= messageRepository.getMessage(message.getIdMessage());
            if(e.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }
     public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= messageRepository.getMessage(message.getIdMessage());
            if(e.isPresent()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    
    public boolean deleteMessage (int id){
        Boolean d = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return d;
    }
    
}
