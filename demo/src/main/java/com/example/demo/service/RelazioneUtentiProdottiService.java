package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Ddt;
import com.example.demo.entity.RelazioneUtentiProdotti;

public interface RelazioneUtentiProdottiService {
    
    RelazioneUtentiProdotti createRelazioneUtenteProdotto(RelazioneUtentiProdotti relazione);

    RelazioneUtentiProdotti getRelazioneUtenteProdottoById(int id);

    List<RelazioneUtentiProdotti> getAllRelazioni();

    List<Optional<RelazioneUtentiProdotti>> getRelazioniByProdotto(Prodotto prodotto);

    List<Optional<RelazioneUtentiProdotti>> getRelazioniByUtente(Utente utente);

    List<Optional<RelazioneUtentiProdotti>> getRelazioniByDdt(Ddt ddt);

    void deleteRelazione(int relazioneId);
}
