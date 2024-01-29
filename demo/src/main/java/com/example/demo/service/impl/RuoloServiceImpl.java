package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente;
import com.example.demo.repository.RuoloRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.service.RuoloService;
import com.example.demo.service.UtenteService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class RuoloServiceImpl implements RuoloService{
    
    private RuoloRepository ruoloRepository;

    @Override
    public Ruolo createRuolo(Ruolo ruolo) {
        return ruoloRepository.save(ruolo);
    }

    @Override
    public Ruolo getRuoloById(int ruoloId) {
        Optional<Ruolo> optionalRuolo = ruoloRepository.findById(ruoloId);
        return optionalRuolo.get();
    }

    @Override
    public List<Ruolo> getAllRuoli() {
        return ruoloRepository.findAll();
    }

    //senza id?
    @Override
    public Ruolo updateRuolo(Ruolo ruolo) {
    	
    	/*Utente existingUtente = utenteRepository.findById(utente.getId()).get();
        existingUtente.setNome(utente.getNome());        
        Utente updatedUtente = utenteRepository.save(existingUtente);*/
        return ruoloRepository.save(ruolo);
    }

    @Override
    public void deleteRuolo(int ruoloId) {
    	ruoloRepository.deleteById(ruoloId);
    }

}
