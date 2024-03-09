package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Preventivo;
import com.example.demo.entity.RelazionePreventivoProdotto;
import com.example.demo.service.RelazionePreventivoProdottoService;

import lombok.AllArgsConstructor;

import com.example.demo.repository.RelazionePreventivoProdottoRepository;


@Service
@AllArgsConstructor
public class RelazionePreventivoProdottoServiceImpl implements RelazionePreventivoProdottoService{
    
    private final RelazionePreventivoProdottoRepository relazioneRepository;

    @Override
    public RelazionePreventivoProdotto createRelazione(RelazionePreventivoProdotto relazione){
        return relazioneRepository.save(relazione);
    }

    @Override
    public RelazionePreventivoProdotto getRelazioneById(int relazioneId){
        RelazionePreventivoProdotto relazione = relazioneRepository.findById(relazioneId);
        return relazione;
    }

    @Override
    public List<RelazionePreventivoProdotto> getAllRelazioni(){
        return relazioneRepository.findAll();
    }

    @Override
    public List<Optional<RelazionePreventivoProdotto>> getRelazioniByPreventivo(Preventivo preventivo){
        List<Optional<RelazionePreventivoProdotto>> optionalRelazioni = relazioneRepository.findByPreventivo(preventivo);
        return optionalRelazioni;
    }

    @Override
    public List<Optional<RelazionePreventivoProdotto>> getRelazioniByProdotto(Prodotto prodotto){
        List<Optional<RelazionePreventivoProdotto>> optonalRelazioni = relazioneRepository.findByProdotto(prodotto);
        return optonalRelazioni;
    }

    @Override 
    public RelazionePreventivoProdotto updateRelazione(RelazionePreventivoProdotto relazione) {
        return relazioneRepository.save(relazione);
    }

    @Override
    public void deleteRelazione (int relazioneId){
        relazioneRepository.deleteById(relazioneId);
    }
}
