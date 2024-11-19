package com.example.demo.service;
import com.example.demo.entity.TipoTask;
import java.util.Optional;
import java.util.List;


public interface TipoTaskService {
    
    TipoTask create(TipoTask tipo);

    Optional<TipoTask> getTipoById(int tipoId);

    List<TipoTask> getAllTipi();

    void deleteTipo(int tipoId);
} 
