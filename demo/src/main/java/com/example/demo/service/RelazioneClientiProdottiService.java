package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.RelazioneClientiProdotti;

public interface RelazioneClientiProdottiService {
    
    RelazioneClientiProdotti createRelazione(RelazioneClientiProdotti relazione);

    RelazioneClientiProdotti getRelazioneById(int relazioneId);

    List<RelazioneClientiProdotti> getAllRelazioni();

    List<RelazioneClientiProdotti> getAllRelazioniByCliente(Cliente cliente);

    List<RelazioneClientiProdotti> getAllRelazioniByProdotto(Prodotto prodotto);

    void deleteRelazione(int relazioneId);
}
