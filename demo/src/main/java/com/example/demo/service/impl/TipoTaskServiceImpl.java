package com.example.demo.service.impl;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TipoTask;
import com.example.demo.repository.TipoTaskRepository;
import com.example.demo.service.TipoTaskService;
import java.util.List;
import lombok.AllArgsConstructor;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoTaskServiceImpl implements TipoTaskService{

    private TipoTaskRepository tipoRepository;

    @Override
    public TipoTask create(TipoTask tipo){
        return tipoRepository.save(tipo);
    }

    @Override
    public Optional<TipoTask> getTipoById(int tipoId){
        return tipoRepository.findById(tipoId);
    }

    @Override
    public List<TipoTask> getAllTipi(){
        return tipoRepository.findAll();
    }

    @Override
    public void deleteTipo(int tipoId){
        tipoRepository.deleteById(tipoId);
    }
    
}
