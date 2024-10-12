package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Fornitore;
import com.example.demo.entity.RestituzioneMerce;
import com.example.demo.entity.Utente;
import com.example.demo.repository.FornitoreRepository;
import com.example.demo.repository.RestituzioneMerceRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.service.RestituzioneMerceService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestituzioneMerceServiceImpl implements RestituzioneMerceService{
   
    @Autowired
    private RestituzioneMerceRepository restituzioneRepository;

    @Autowired
    private FornitoreRepository fornitoreRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public RestituzioneMerce createRestituzione(RestituzioneMerce restituzione){
        return restituzioneRepository.save(restituzione);
    }

    @Override
    public List<RestituzioneMerce> getAllRestituzioni(){
        return restituzioneRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Optional<RestituzioneMerce> getRestituzioneById(int restituzioneId){
        return restituzioneRepository.findById(restituzioneId);
    }

    @Override
    public List<RestituzioneMerce> getRestituzioniByFornitore(Fornitore fornitore){
        return restituzioneRepository.findByFornitore(fornitore);
    }

    @Override
    public List<RestituzioneMerce> getRestituzioneByUtenteConsegna(Utente utente){
        return restituzioneRepository.findByUtenteRiconsegna(utente);
    }

    @Override
    public List<RestituzioneMerce> getRestituzioneByUtenteRitiro(Utente utente){
        return restituzioneRepository.findByUtenteRitiro(utente);
    }

    @Override
    public void deleteRestituzione(int restituzioneId){
        restituzioneRepository.deleteById(restituzioneId);
    }
}
