package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import com.example.demo.repository.RelazioneUtentiInterventiRepository;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.RelazioneUtentiInterventi;
import com.example.demo.service.RelazioneUtentiInterventiService;


@Service
@AllArgsConstructor
public class RelazioneUtentiInterventiServiceImpl implements RelazioneUtentiInterventiService{
    
    private final RelazioneUtentiInterventiRepository relazioneRepository;

    @Override
    public RelazioneUtentiInterventi createRelazioneUtentiInterventi(RelazioneUtentiInterventi relazione){
        return relazioneRepository.save(relazione);
    }

    @Override
    public Optional<RelazioneUtentiInterventi> getRelazioneById(int id){
        Optional<RelazioneUtentiInterventi> optionalRelazione = relazioneRepository.findById(id);
        return optionalRelazione;
    }

    @Override
    public List<RelazioneUtentiInterventi> getAllRelazioni(){
        return relazioneRepository.findAll();
    }

    @Override
    public List<Optional<RelazioneUtentiInterventi>> getRelazioniByUtente(Utente utente){
        List<Optional<RelazioneUtentiInterventi>> optionalRelazioni = relazioneRepository.findByUtente(utente);
        return optionalRelazioni;
    }

    @Override
    public List<Optional<RelazioneUtentiInterventi>> getRelazioniByIntervento(Intervento intervento){
        List<Optional<RelazioneUtentiInterventi>> optionalRelazioni = relazioneRepository.findByIntervento(intervento);
        return optionalRelazioni;
    }

    @Override
    public RelazioneUtentiInterventi updateRelazione(RelazioneUtentiInterventi relazione){
        return relazioneRepository.save(relazione);
    }

    @Override
    public void deleteRelazione(int relazioenId){
        relazioneRepository.deleteById(relazioenId);
    }
}
