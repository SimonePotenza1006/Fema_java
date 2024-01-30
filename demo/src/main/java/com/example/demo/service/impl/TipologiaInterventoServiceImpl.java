package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.repository.TipologiaInterventoRepository;
import com.example.demo.service.TipologiaInterventoService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@AllArgsConstructor
public class TipologiaInterventoServiceImpl implements TipologiaInterventoService{
    
    private TipologiaInterventoRepository tipologiaInterventoRepository;

    @Override
    public TipologiaIntervento createTipologiaIntervento(TipologiaIntervento tipologiaIntervento){
        return tipologiaInterventoRepository.save(tipologiaIntervento);
    }

    @Override
    public TipologiaIntervento getTipologiaInterventoById(int tipologiaInterventoId) {
        Optional<TipologiaIntervento> optionalTipologiaIntervento = tipologiaInterventoRepository.findById(tipologiaInterventoId);
        return optionalTipologiaIntervento.get();
    }

    @Override 
    public List<TipologiaIntervento> getAllTipologieIntervento(){
        return tipologiaInterventoRepository.findAll();
    }

    @Override
    public TipologiaIntervento updateTipologiaIntervento(TipologiaIntervento tipologiaIntervento){
        return tipologiaInterventoRepository.save(tipologiaIntervento);
    }

    @Override
    public void deleteTipologiaIntervento(int tipologiaInterventoId){
        tipologiaInterventoRepository.deleteById(tipologiaInterventoId);
    }

}
