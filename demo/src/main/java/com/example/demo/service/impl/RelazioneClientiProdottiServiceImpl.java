package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.RelazioneClientiProdotti;
import com.example.demo.repository.RelazioneClientiProdottiRepository;
import com.example.demo.service.RelazioneClientiProdottiService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RelazioneClientiProdottiServiceImpl implements RelazioneClientiProdottiService{

    private final RelazioneClientiProdottiRepository relazioneRepository;

    @Override
    public RelazioneClientiProdotti createRelazione(RelazioneClientiProdotti relazione){
        return relazioneRepository.save(relazione);
    }

    @Override
    public RelazioneClientiProdotti getRelazioneById(int id){
        RelazioneClientiProdotti relazione = relazioneRepository.findById(id);
        return relazione;
    }

    @Override
    public List<RelazioneClientiProdotti> getAllRelazioni(){
        return relazioneRepository.findAll();
    }
    
    @Override
    public List<RelazioneClientiProdotti> getAllRelazioniByCliente(Cliente cliente){
        List<RelazioneClientiProdotti> relazioni = relazioneRepository.findByCliente(cliente);
        return relazioni;
    }

    @Override
    public List<RelazioneClientiProdotti> getAllRelazioniByProdotto(Prodotto prodotto){
        List<RelazioneClientiProdotti> relazioni = relazioneRepository.findByProdotto(prodotto);
        return relazioni;
    }

    @Override
    public void deleteRelazione(int relazioneId){
        relazioneRepository.deleteById(relazioneId);
    }
    
}
