package com.example.demo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Utente;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.InterventoRepository;
import com.example.demo.repository.TipologiaInterventoRepository;
import com.example.demo.service.InterventoService;


public class InterventoServiceImpl implements InterventoService{
    
    private TipologiaInterventoRepository tipologiaInterventoRepository;
    private UtenteRepository utenteRepository;
    private ClienteRepository clienteRepository;
    private InterventoRepository interventoRepository;

    @Override
    public Intervento createIntervento(Intervento intervento) {
        return interventoRepository.save(intervento);
    }

    @Override
    public Intervento getInterventoById(int interventoId){
        Optional<Intervento> optionalIntervento = interventoRepository.findById(interventoId);
        return optionalIntervento.get();
    }

    @Override
    public List<Intervento> getAllInterventi(){
        return interventoRepository.findAll();
    }

    @Override
    public List<Optional<Intervento>> getInterventoByCliente(Cliente cliente){
        List<Optional<Intervento>> optionalIntervento = interventoRepository.findByCliente(cliente);
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
    public Intervento updateIntervento(Intervento intervento){
        return interventoRepository.save(intervento);
    }

    @Override 
    public void deleteIntervento(int interventoId){
        interventoRepository.deleteById(interventoId);
    }

}
