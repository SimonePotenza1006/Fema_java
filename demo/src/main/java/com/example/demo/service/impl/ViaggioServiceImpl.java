package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Viaggio;
import com.example.demo.entity.Utente;
import com.example.demo.repository.ViaggioRepository;
import com.example.demo.service.ViaggioService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ViaggioServiceImpl implements ViaggioService{
    
    private ViaggioRepository viaggioRepository;

    @Override
    public Viaggio createViaggio(Viaggio viaggio){
        return viaggioRepository.save(viaggio);
    }

    @Override
    public Viaggio getViaggioById(int viaggioId) {
        Optional<Viaggio> optionalViaggio = viaggioRepository.findById(viaggioId);
        return optionalViaggio.get();
    }

    // @Override
    // public List<Optional<Viaggio>> getViaggioByUtente(Utente utente) {
    	
    //     List<Optional<Viaggio>> optionalViaggio = viaggioRepository.findByUtenti(utente);
        
    //     return optionalViaggio;
    // }

    @Override 
    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAllByOrderByIdDesc();
    }
    
    @Override
    public Viaggio updateViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    @Override
    public void deleteViaggio(int viaggioId){
        viaggioRepository.deleteById(viaggioId);
    }
}
