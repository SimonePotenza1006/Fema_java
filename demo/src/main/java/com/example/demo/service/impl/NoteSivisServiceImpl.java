package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.NoteSivisService;
import com.example.demo.entity.NoteSivis;
import com.example.demo.repository.NoteSivisRepository;

import java.util.Optional;

import lombok.AllArgsConstructor;
import java.util.List;


@Service
@AllArgsConstructor
public class NoteSivisServiceImpl implements NoteSivisService{
    
    @Autowired
    private NoteSivisRepository notaRepository;

    @Override
    public NoteSivis createNota(NoteSivis nota){
        return notaRepository.save(nota);
    }

    @Override 
    public NoteSivis getNotaById(int notaId){
        Optional<NoteSivis> optionalNota = notaRepository.findById(notaId);
        return optionalNota.get();
    }

    @Override 
    public List<NoteSivis> getAllNoteOrderByDesc(){
        List<NoteSivis> optionalNote = notaRepository.findAllByOrderByIdDesc();
        return optionalNote;
    }
}
