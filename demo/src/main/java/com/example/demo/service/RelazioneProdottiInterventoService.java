package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Ddt;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.RelazioneProdottiIntervento;

public interface RelazioneProdottiInterventoService {
    
    RelazioneProdottiIntervento createRelazione(RelazioneProdottiIntervento relazione);

    RelazioneProdottiIntervento getRelazione(int relazioneId);

    List<RelazioneProdottiIntervento> getAllRelazioni();

    List<Optional<RelazioneProdottiIntervento>> getRelazioniByProdotto(Prodotto prodotto);

    List<Optional<RelazioneProdottiIntervento>> getRelazioniByDdt(Ddt ddt);

    List<Optional<RelazioneProdottiIntervento>> getRelazioniByIntervento(Intervento intervento);

    void deleteRelazione(int relazioneId);

}
