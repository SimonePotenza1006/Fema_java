package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Preventivo;
import com.example.demo.entity.RelazionePreventivoProdotto;


public interface RelazionePreventivoProdottoService {
    
    RelazionePreventivoProdotto createRelazione (RelazionePreventivoProdotto relazione);

    RelazionePreventivoProdotto getRelazioneById (int relazioneId);

    List<RelazionePreventivoProdotto> getAllRelazioni();

    List<Optional<RelazionePreventivoProdotto>> getRelazioniByPreventivo (Preventivo preventivo);

    List<Optional<RelazionePreventivoProdotto>> getRelazioniByProdotto (Prodotto prodotto);

    RelazionePreventivoProdotto updateRelazione (RelazionePreventivoProdotto relazione);

    void deleteRelazione(int relazioneId);
}
