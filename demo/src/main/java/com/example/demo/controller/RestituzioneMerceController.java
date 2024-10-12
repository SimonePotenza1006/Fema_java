package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Fornitore;
import com.example.demo.entity.RestituzioneMerce;
import com.example.demo.entity.Utente;
import com.example.demo.service.FornitoreService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.impl.RestituzioneMerceServiceImpl;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/restituzionMerce")
public class RestituzioneMerceController {
    
    @Autowired
    private RestituzioneMerceServiceImpl restituzioneService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private FornitoreService fornitoreService;

    @PostMapping
    public ResponseEntity<RestituzioneMerce> createRestituzione(@RequestBody RestituzioneMerce restituzione){
        RestituzioneMerce savedRestituzione = restituzioneService.createRestituzione(restituzione);
        return new ResponseEntity<>(savedRestituzione, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<RestituzioneMerce>> getRestituzioneById(@PathVariable("id") int restituzioneId){
        int idvariable = restituzioneId;
        Optional<RestituzioneMerce> restituzione = restituzioneService.getRestituzioneById(idvariable);
        if(restituzione == null){
            System.out.println("Restituzione non trovata con ID: " + restituzioneId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(restituzione, HttpStatus.OK);
    }   

    @GetMapping
    public ResponseEntity<List<RestituzioneMerce>> getAllRestituzioni(){
        List<RestituzioneMerce> restituzioni = restituzioneService.getAllRestituzioni();
        return new ResponseEntity<>(restituzioni, HttpStatus.OK);
    }

    @GetMapping("/fornitore/{id}")
    public ResponseEntity<List<RestituzioneMerce>> getRestituzioniByFornitore(@PathVariable("id") int fornitoreId){
        Fornitore fornitore = fornitoreService.getFornitoreById(fornitoreId);
        List<RestituzioneMerce> restituzioni = restituzioneService.getRestituzioniByFornitore(fornitore);
        return new ResponseEntity<>(restituzioni, HttpStatus.OK);
    }

    @GetMapping("/utenteRiconsegna/{id}")
    public ResponseEntity<List<RestituzioneMerce>> getRestituzioniByUtenteRiconsegna(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<RestituzioneMerce> restituzioni = restituzioneService.getRestituzioneByUtenteConsegna(utente);
        return new ResponseEntity<>(restituzioni, HttpStatus.OK);
    }

    @GetMapping("/utenteRitiro/{id}")
    public ResponseEntity<List<RestituzioneMerce>> getRestituzioniByUtenteRitiro(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<RestituzioneMerce> restituzioni = restituzioneService.getRestituzioneByUtenteRitiro(utente);
        return new ResponseEntity<>(restituzioni, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRestituzione(@PathVariable("id") int restituzioneId){
        restituzioneService.deleteRestituzione(restituzioneId);
        return new ResponseEntity<>("Restituzione eliminata!", HttpStatus.OK);
    }
}
