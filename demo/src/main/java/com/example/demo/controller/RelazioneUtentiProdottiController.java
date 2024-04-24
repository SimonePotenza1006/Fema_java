package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Ddt;
import com.example.demo.entity.RelazioneUtentiProdotti;
import com.example.demo.service.DdtService;
import com.example.demo.service.ProdottoService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.impl.RelazioneUtentiProdottiServiceImpl;

@RestController
@RequestMapping(value = "/api/relazioneUtentiProdotti")
public class RelazioneUtentiProdottiController {

    @Autowired
    private RelazioneUtentiProdottiServiceImpl relazioneService;
    
    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private DdtService ddtService;

    @Autowired
    private UtenteService utenteService;

    @PostMapping
    public ResponseEntity<RelazioneUtentiProdotti> createRelazione(@RequestBody RelazioneUtentiProdotti relazioneUtentiProdotti){
        RelazioneUtentiProdotti relazione = relazioneService.createRelazioneUtenteProdotto(relazioneUtentiProdotti);
        return new ResponseEntity<>(relazione, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RelazioneUtentiProdotti> getRelazioniById(@PathVariable("id") int relazioneId){
        RelazioneUtentiProdotti relazione = relazioneService.getRelazioneUtenteProdottoById(relazioneId);
        return new ResponseEntity<>(relazione, HttpStatus.OK);
    }

    @GetMapping("/prodotto/{id}")
    public ResponseEntity<List<Optional<RelazioneUtentiProdotti>>> getRelazioniByProdotto(@PathVariable("id") int prodottoId){
        Prodotto prodotto = prodottoService.getProdottoById(prodottoId);
        List<Optional<RelazioneUtentiProdotti>> relazioni = relazioneService.getRelazioniByProdotto(prodotto);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/ddt/{id}")
    public ResponseEntity<List<Optional<RelazioneUtentiProdotti>>> getRelazioniByDdt(@PathVariable("id") int ddtId){
        Ddt ddt = ddtService.getDdtById(ddtId);
        List<Optional<RelazioneUtentiProdotti>> relazioni = relazioneService.getRelazioniByDdt(ddt);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<RelazioneUtentiProdotti>>> getRelazioniByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<RelazioneUtentiProdotti>> relazioni = relazioneService.getRelazioniByUtente(utente);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRelazione(@PathVariable("id") int relazioneId){
        relazioneService.deleteRelazione(relazioneId);
        return new ResponseEntity<>("Relazione successfully deleted!", HttpStatus.OK);
    }

}
