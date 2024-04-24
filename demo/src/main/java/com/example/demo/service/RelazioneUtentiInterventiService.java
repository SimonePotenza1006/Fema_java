package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.RelazioneUtentiInterventi;

public interface RelazioneUtentiInterventiService {

    RelazioneUtentiInterventi createRelazioneUtentiInterventi(RelazioneUtentiInterventi relazione);

    Optional<RelazioneUtentiInterventi> getRelazioneById(int id);

    List<RelazioneUtentiInterventi> getAllRelazioni();

    List<Optional<RelazioneUtentiInterventi>> getRelazioniByUtente(Utente utente);

    List<Optional<RelazioneUtentiInterventi>> getRelazioniByIntervento(Intervento intervento);

    RelazioneUtentiInterventi updateRelazione(RelazioneUtentiInterventi relazione);

    void deleteRelazione(int relazioneId);
}