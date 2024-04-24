package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Veicolo;
import com.example.demo.entity.SpesaVeicolo;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import com.example.demo.repository.SpesaVeicoloRepository;
import com.example.demo.service.SpesaVeicoloService;



@Service
@AllArgsConstructor
public class SpesaVeicoloServiceImpl implements SpesaVeicoloService{
    
    @Autowired
    private SpesaVeicoloRepository spesaRepository;

    @Override
    public SpesaVeicolo createSpesa(SpesaVeicolo spesa){
        return spesaRepository.save(spesa);
    }

    @Override
    public SpesaVeicolo getSpesaById(int spesaId){
        Optional<SpesaVeicolo> optionalSpesa = spesaRepository.findById(spesaId);
        return optionalSpesa.get();
    }

    @Override
    public List<SpesaVeicolo> getAllSpese(){
        return spesaRepository.findAll();
    }

    @Override
    public List<SpesaVeicolo> getAllSpesaVeicoloOrderByDesc(){
        List<SpesaVeicolo> optionalSpese = spesaRepository.findAllByOrderByIdDesc();
        return optionalSpese;
    }

    @Override
    public List<Optional<SpesaVeicolo>> getSpeseVeicoloByUtente(Utente utente){
        List<Optional<SpesaVeicolo>> optionalSpese = spesaRepository.findByUtente(utente);
        return optionalSpese;
    }

    @Override
    public List<Optional<SpesaVeicolo>> getSpeseVeicoloByVeicolo(Veicolo veicolo) {
        List<Optional<SpesaVeicolo>> optionalSpese = spesaRepository.findByVeicolo(veicolo);
        return optionalSpese;
    }

    @Override
    public SpesaVeicolo updateSpesa(SpesaVeicolo spesa){
        return spesaRepository.save(spesa);
    }

    @Override
    public void deleteSpesa(int spesaId){
        spesaRepository.deleteById(spesaId);
    }
}
