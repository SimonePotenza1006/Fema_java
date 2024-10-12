package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Fornitore;
import com.example.demo.entity.RestituzioneMerce;
import com.example.demo.entity.Utente;

public interface RestituzioneMerceService {
    
    RestituzioneMerce createRestituzione(RestituzioneMerce restituzione);

    Optional<RestituzioneMerce> getRestituzioneById(int restituzioneId);

    List<RestituzioneMerce> getAllRestituzioni();

    List<RestituzioneMerce> getRestituzioniByFornitore(Fornitore fornitore);

    List<RestituzioneMerce> getRestituzioneByUtenteConsegna(Utente utente);

    List<RestituzioneMerce> getRestituzioneByUtenteRitiro(Utente utente);

    void deleteRestituzione(int restituzioneId);
}
