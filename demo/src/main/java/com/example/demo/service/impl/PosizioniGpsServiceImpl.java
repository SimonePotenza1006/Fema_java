package com.example.demo.service.impl;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.PosizioniGps;
import com.example.demo.repository.PosizioniGpsRepository;
import com.example.demo.service.PosizioniGpsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PosizioniGpsServiceImpl implements PosizioniGpsService{
    
    @Autowired
    private PosizioniGpsRepository posizioneRepository;

    @Override 
    public PosizioniGps createPosizione(PosizioniGps posizione){
        return posizioneRepository.save(posizione);
    }

    @Override 
    public PosizioniGps getPosizioneById(int posizioneId){
        Optional<PosizioniGps> optionalPosizone = posizioneRepository.findById(posizioneId);
        return optionalPosizone.get();
    }

    @Override 
    public List<PosizioniGps> getAllPosizioniOrderByDesc(){
        List<PosizioniGps> optionalPosizioni = posizioneRepository.findAllByOrderByIdDesc();
        return optionalPosizioni;
    }

    @Override 
    public List<Optional<PosizioniGps>> getPosizioneByCliente(Cliente cliente){
        List<Optional<PosizioniGps>> optionalPosizioni = posizioneRepository.findByCliente(cliente);
        return optionalPosizioni;
    }

    @Override 
    public void deletePosizione(int posizioneId){
        posizioneRepository.deleteById(posizioneId);
    }
}
