package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Ddt;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.RelazioneDdtProdotto;
import com.example.demo.repository.RelazioneDdtProdottoRepository;
import com.example.demo.service.RelazioneDdtProdottoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RelazioneDdtProdottoServiceImpl implements RelazioneDdtProdottoService{
    
    private final RelazioneDdtProdottoRepository relazioneRepository;

    @Override
    public RelazioneDdtProdotto createRelazioneDdtProdotto(RelazioneDdtProdotto relazione){
        return relazioneRepository.save(relazione);
    }

    @Override
    public RelazioneDdtProdotto getRelazioneDdtProdottoById(int relazioneId){
        Optional<RelazioneDdtProdotto> optionalRelazione = relazioneRepository.findById(relazioneId);
        return optionalRelazione.orElse(null);
    }

    @Override
    public List<RelazioneDdtProdotto> getAllRelazioni(){
        return relazioneRepository.findAll();
    }

    @Override
    public List<Optional<RelazioneDdtProdotto>> getRelazioniByProdotto(Prodotto prodotto){
        List<Optional<RelazioneDdtProdotto>> optionalRelazioni = relazioneRepository.findByProdotto(prodotto);
        return optionalRelazioni;
    }

    @Override
    public List<RelazioneDdtProdotto> findByStatus(boolean scaricato) {
        return relazioneRepository.findByScaricato(scaricato);
    }

    @Override
    public List<Optional<RelazioneDdtProdotto>> getRelazioniByDdt(Ddt ddt){
        List<Optional<RelazioneDdtProdotto>> optionalRelazioni = relazioneRepository.findByDdt(ddt);
        return optionalRelazioni;
    }

    @Override
    public RelazioneDdtProdotto updateRelazione(RelazioneDdtProdotto relazione){
        return relazioneRepository.save(relazione);
    }

    @Override
    public void deleteRelazione (int relazioneId){
        relazioneRepository.deleteById(relazioneId);
    }
}
