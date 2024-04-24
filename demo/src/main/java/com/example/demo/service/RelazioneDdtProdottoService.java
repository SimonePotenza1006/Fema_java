package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Ddt;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.RelazioneDdtProdotto;

public interface RelazioneDdtProdottoService {
    
    RelazioneDdtProdotto createRelazioneDdtProdotto(RelazioneDdtProdotto relazione);

    RelazioneDdtProdotto getRelazioneDdtProdottoById(int relazioneId);

    List<RelazioneDdtProdotto> getAllRelazioni();

    List<RelazioneDdtProdotto> findByStatus(boolean scaricato);

    List<Optional<RelazioneDdtProdotto>> getRelazioniByProdotto (Prodotto prodotto);

    List<Optional<RelazioneDdtProdotto>> getRelazioniByDdt(Ddt ddt);

    RelazioneDdtProdotto updateRelazione(RelazioneDdtProdotto relazione);

    void deleteRelazione(int relazioneId);
}
