package com.intento4.intento4.Repositorio;

import com.intento4.intento4.Interface.ScoreInterface;
import com.intento4.intento4.Modelo.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class ScoreRepositorio {
    
    @Autowired
    private ScoreInterface scoreCrudRepository;

    public List<Score> getAll() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score score) {
        return scoreCrudRepository.save(score);
    }
    
    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
}
