package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.repository.RelazioneUtentiProdottiRepository;
import com.example.demo.service.RelazioneUtentiProdottiService;
import com.example.demo.entity.Ddt;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.RelazioneUtentiProdotti;
import com.example.demo.entity.Utente;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RelazioneUtentiProdottiServiceImpl implements RelazioneUtentiProdottiService{
    
    private final RelazioneUtentiProdottiRepository relazioneRepository;

    @Override
    public RelazioneUtentiProdotti createRelazioneUtenteProdotto(RelazioneUtentiProdotti relazione){
        return relazioneRepository.save(relazione);
    }

    @Override
    public RelazioneUtentiProdotti getRelazioneUtenteProdottoById(int id){
        Optional<RelazioneUtentiProdotti> optionalRelazione = relazioneRepository.findById(id);
        return optionalRelazione.get();
    }

    @Override
    public List<RelazioneUtentiProdotti> getAllRelazioni(){
        return relazioneRepository.findAll();
    }

    @Override
    public List<Optional<RelazioneUtentiProdotti>> getRelazioniByProdotto(Prodotto prodotto){
        List<Optional<RelazioneUtentiProdotti>> optionalRelazioni = relazioneRepository.findByProdotto(prodotto);
        return optionalRelazioni;
    }

    @Override
    public List<Optional<RelazioneUtentiProdotti>> getRelazioniByUtente(Utente utente){
        List<Optional<RelazioneUtentiProdotti>> optionalRelazioni = relazioneRepository.findByUtente(utente);
        return optionalRelazioni;
    }

    @Override
    public List<Optional<RelazioneUtentiProdotti>> getRelazioniByDdt(Ddt ddt){
        List<Optional<RelazioneUtentiProdotti>> optionalRelazioni = relazioneRepository.findByDdt(ddt);
        return optionalRelazioni;
    }

    @Override
    public void deleteRelazione(int relazioenId){
        relazioneRepository.deleteById(relazioenId);
    }
}
