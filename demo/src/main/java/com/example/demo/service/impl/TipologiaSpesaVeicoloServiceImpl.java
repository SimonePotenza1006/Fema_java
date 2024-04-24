package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TipologiaSpesaVeicolo;
import com.example.demo.repository.TipologiaSpesaVeicoloRepository;
import com.example.demo.service.TipologiaSpesaVeicoloService;

import java.util.Optional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipologiaSpesaVeicoloServiceImpl implements TipologiaSpesaVeicoloService{
    
    private TipologiaSpesaVeicoloRepository tipologiaRepository;

    @Override
    public TipologiaSpesaVeicolo createTipologia(TipologiaSpesaVeicolo tipologia){
        return tipologiaRepository.save(tipologia);
    }

    @Override 
    public TipologiaSpesaVeicolo getTipologiaSpesaVeicoloById(int tipologiaId){
        Optional<TipologiaSpesaVeicolo> optionalTipologia = tipologiaRepository.findById(tipologiaId);
        return optionalTipologia.get();
    }

    @Override 
    public List<TipologiaSpesaVeicolo> getAllTipologie(){
        return tipologiaRepository.findAll();
    }

    @Override 
    public TipologiaSpesaVeicolo updateTipologia(TipologiaSpesaVeicolo tipologia){
        return tipologiaRepository.save(tipologia);
    }

    @Override 
    public void deleteTipologia(int tipologiaId){
        tipologiaRepository.deleteById(tipologiaId);
    }
}
