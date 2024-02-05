package com.example.demo.service.impl;

import org.apache.logging.log4j.util.Strings;
import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.repository.OrdinePerInterventoRepository;
import com.example.demo.service.OrdinePerInterventoService;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.OrdinePerIntervento;
import com.example.demo.entity.Utente;
import com.example.demo.repository.InterventoRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class OrdinePerInterventoServiceImpl implements OrdinePerInterventoService{
    
    private OrdinePerInterventoRepository ordineRepository;
    private InterventoRepository InterventoRepository;

    @Override
    public OrdinePerIntervento createOrdine(OrdinePerIntervento ordine){
        return ordineRepository.save(ordine);
    }

    @Override
    public OrdinePerIntervento getOrdineById(int ordineId){
        Optional<OrdinePerIntervento> optionalOrdine = ordineRepository.findById(ordineId);
        return optionalOrdine.get();
    }

    @Override
    public List<OrdinePerIntervento> getAllOrdini(){
        return ordineRepository.findAll();
    }

    @Override
    public List<Optional<OrdinePerIntervento>> getOrdineByIntervento(Intervento intervento){
        List<Optional<OrdinePerIntervento>> optionalOrdine = ordineRepository.findByIntervento(intervento);
        return optionalOrdine;
    }

    @Override 
    public List<Optional<OrdinePerIntervento>> getOrdineByUtente(Utente utente){
        List<Optional<OrdinePerIntervento>> optionalOrdineList = ordineRepository.findByUtente(utente);
        return optionalOrdineList;
    }

    @Override
    public OrdinePerIntervento updateOrdine(OrdinePerIntervento ordine){
        return ordineRepository.save(ordine);
    }

    @Override
    public void deleteOrdine(int ordineId){
        ordineRepository.deleteById(ordineId);
    }
}
