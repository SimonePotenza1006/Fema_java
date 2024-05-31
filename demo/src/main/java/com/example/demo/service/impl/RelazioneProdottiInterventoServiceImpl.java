package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import com.example.demo.entity.Ddt;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.RelazioneProdottiIntervento;
import com.example.demo.service.RelazioneProdottiInterventoService;
import com.example.demo.repository.RelazioneProdottiInterventoRepository;

@Service
@AllArgsConstructor
public class RelazioneProdottiInterventoServiceImpl implements RelazioneProdottiInterventoService{
    
    private final RelazioneProdottiInterventoRepository relazioneRepository;

    @Override
    public RelazioneProdottiIntervento createRelazione(RelazioneProdottiIntervento relazione){
        return relazioneRepository.save(relazione);
    }

    @Override
    public RelazioneProdottiIntervento getRelazione(int relazioneId){
        Optional<RelazioneProdottiIntervento> optionalRelazione = relazioneRepository.findById(relazioneId);
        return optionalRelazione.orElse(null);
    }

    @Override 
    public List<RelazioneProdottiIntervento> getAllRelazioni(){
        return relazioneRepository.findAll();
    }

    @Override 
    public List<Optional<RelazioneProdottiIntervento>> getRelazioniByProdotto(Prodotto prodotto){
        List<Optional<RelazioneProdottiIntervento>> optionalProdotti = relazioneRepository.findByProdotto(prodotto);
        return optionalProdotti;
    }

    @Override 
    public List<Optional<RelazioneProdottiIntervento>> getRelazioniByDdt(Ddt ddt){
        List<Optional<RelazioneProdottiIntervento>> optionalRelazioni = relazioneRepository.findByDdt(ddt);
        return optionalRelazioni;
    }

    @Override 
    public List<Optional<RelazioneProdottiIntervento>> getRelazioniByIntervento(Intervento intervento){
        List<Optional<RelazioneProdottiIntervento>> optionalRelazioni = relazioneRepository.findByIntervento(intervento);
        return optionalRelazioni;
    }

    @Override 
    public void deleteRelazione(int relazioneId){
        relazioneRepository.deleteById(relazioneId);
    }
}
