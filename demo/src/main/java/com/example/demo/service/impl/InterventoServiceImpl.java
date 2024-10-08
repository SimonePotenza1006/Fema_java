package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.GruppoInterventi;
import com.example.demo.entity.Utente;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.InterventoRepository;
import com.example.demo.repository.TipologiaInterventoRepository;
import com.example.demo.service.InterventoService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@Service
@AllArgsConstructor
public class InterventoServiceImpl implements InterventoService{
    
    @Autowired
    private InterventoRepository interventoRepository;
    

    @Override
    public Intervento createIntervento(Intervento intervento) {
        return interventoRepository.save(intervento);
    }

    // @Override
    // public Intervento getInterventoById(int interventoId) {
    //     System.out.println("Richiesta di recuperare l'intervento con ID: " + interventoId);
    //     Optional<Intervento> optionalIntervento = interventoRepository.findById(interventoId);
    //     if (optionalIntervento.isPresent()) {
    //         return optionalIntervento.get();
    //     } else {
    //         throw new NoSuchElementException("Intervento non trovato con ID: " + interventoId);
    //     }
    // }

    @Override
    public List<Intervento> getAllInterventiOrderdByDesc(){
        List<Intervento> optionalInterventi = interventoRepository.findAllByOrderByIdDesc();
        return optionalInterventi;
    }

    @Override 
    public List<Intervento> getInterventiOrderedByGruppo(){
        List<Intervento> optionalInterventi = interventoRepository.findAllOrderByGruppoOrderById();
        return optionalInterventi;
    }

    @Override
    public Intervento getInterventoById(int interventoId) {
        Optional<Intervento> optionalIntervento = interventoRepository.findById(interventoId);
        return optionalIntervento.get();
    }

    @Override
    public List<Intervento> getAllInterventi(){
        return interventoRepository.findAll();
    }

    @Override
    public List<Intervento> getAllInterventiWithMerceNonConclusiByUtente(Utente utente){
        return interventoRepository.findByMerceNotNullAndDataConsegnaIsNullAndUtente(utente);
    }

    @Override
    public List<Intervento> getAllInterventiWithMerce(){
        return interventoRepository.findDistinctByMerceIsNotNull();
    }

    @Override
    public List<Optional<Intervento>> getInterventoByCliente(Cliente cliente){
        List<Optional<Intervento>> optionalIntervento = interventoRepository.findByCliente(cliente);
        return optionalIntervento;
    }

    @Override
    public List<Intervento> getInterventiByMerce(MerceInRiparazione merce){
        List<Intervento> optionalIntervento = interventoRepository.findByMerce(merce);
        return optionalIntervento;
    }

    @Override 
    public List<Optional<Intervento>> getInterventoByUtente(Utente utente){
        List<Optional<Intervento>> optionalIntervento = interventoRepository.findByUtente(utente);
        return optionalIntervento;
    }

    @Override
    public List<Optional<Intervento>> getInterventoByTipologia(TipologiaIntervento tipologiaIntervento){
        List<Optional<Intervento>> optionalIntervento = interventoRepository.findByTipologia(tipologiaIntervento);
        return optionalIntervento;
    }

    @Override
    public List<Optional<Intervento>> getInterventiByGruppo(GruppoInterventi gruppo){
        List<Optional<Intervento>> optionalInterventi = interventoRepository.findByGruppo(gruppo);
        return optionalInterventi;
    }

    @Override
    public Intervento updateIntervento(Intervento intervento){
        return interventoRepository.save(intervento);
    }

    @Override 
    public void deleteIntervento(int interventoId){
        interventoRepository.deleteById(interventoId);
    }

}