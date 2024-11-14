package com.example.demo.controller;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.RelazioneUtentiInterventi;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Intervento;
import com.example.demo.service.impl.RelazioneUtentiInterventiServiceImpl;
import com.example.demo.service.UtenteService;
import com.example.demo.service.InterventoService;

@RestController
@RequestMapping(value = "/api/relazioneUtentiInterventi")
public class RelazioneUtentiInterventiController {
     
    @Autowired
    private RelazioneUtentiInterventiServiceImpl relazioneService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private InterventoService interventoService;

    @PostMapping
    public ResponseEntity<RelazioneUtentiInterventi> createRelazione(@RequestBody RelazioneUtentiInterventi relazioneUtentiInterventi){
        RelazioneUtentiInterventi relazione = relazioneService.createRelazioneUtentiInterventi(relazioneUtentiInterventi);
        return new ResponseEntity<>(relazione, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<RelazioneUtentiInterventi>> getRelazioneById(@PathVariable("id") int relazioneId){
        Optional<RelazioneUtentiInterventi> relazione = relazioneService.getRelazioneById(relazioneId);
        return new ResponseEntity<>(relazione, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RelazioneUtentiInterventi>> getAllRelazioni(){
        List<RelazioneUtentiInterventi> relazioni = relazioneService.getAllRelazioni();
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<RelazioneUtentiInterventi>>> getRelazioneByProdotto(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<RelazioneUtentiInterventi>> relazioni = relazioneService.getRelazioniByUtente(utente);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/intervento/{id}")
    public ResponseEntity<List<Optional<RelazioneUtentiInterventi>>> getRelazioneByIntervento(@PathVariable("id") int interventoId){
        Intervento intervento = interventoService.getInterventoById(interventoId);
        List<Optional<RelazioneUtentiInterventi>> relazioni = relazioneService.getRelazioniByIntervento(intervento);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/interventoutente/{idi}/{idu}")
    public ResponseEntity<Optional<RelazioneUtentiInterventi>> getRelazioneByInterventoAndUtente(@PathVariable("idi") int interventoId, @PathVariable("idu") int utenteId){
        Intervento intervento = interventoService.getInterventoById(interventoId);
        Utente utente = utenteService.getUtenteById(utenteId);
        Optional<RelazioneUtentiInterventi> relazione = relazioneService.getRelazioneByInterventoAndUtente(intervento, utente);
        return new ResponseEntity<>(relazione, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<RelazioneUtentiInterventi> updateRelazioneDdtProdotto(@RequestBody RelazioneUtentiInterventi relazione) throws IOException{
        RelazioneUtentiInterventi updatedRelazione = relazioneService.updateRelazione(relazione);
        return new ResponseEntity<>(updatedRelazione, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRelazione(@PathVariable("id") int relazioneId){
        relazioneService.deleteRelazione(relazioneId);
        return new ResponseEntity<>("Relazione successfully deleted!", HttpStatus.OK);
    }
}
