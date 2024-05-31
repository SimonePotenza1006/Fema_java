package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Ddt;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.RelazioneProdottiIntervento;
import com.example.demo.service.DdtService;
import com.example.demo.service.ProdottoService;
import com.example.demo.service.InterventoService;
import com.example.demo.service.impl.RelazioneProdottiInterventoServiceImpl;


@RestController
@RequestMapping(value = "/api/relazioneProdottoIntervento")
public class RelazioneProdottiInterventoController {
    
    @Autowired
    private InterventoService interventoService;

    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private DdtService ddtService;

    @Autowired
    private RelazioneProdottiInterventoServiceImpl relazioneService;

    @PostMapping
    public ResponseEntity<RelazioneProdottiIntervento> createRelazione(@RequestBody RelazioneProdottiIntervento relazioneProdottiIntervento){
        RelazioneProdottiIntervento relazione = relazioneService.createRelazione(relazioneProdottiIntervento);
        return new ResponseEntity<>(relazione, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RelazioneProdottiIntervento> getRelazioneById(@PathVariable("id") int relazioneId){
        RelazioneProdottiIntervento relazione = relazioneService.getRelazione(relazioneId);
        return new ResponseEntity<>(relazione, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RelazioneProdottiIntervento>> getAllRelazioni(){
        List<RelazioneProdottiIntervento> relazioni = relazioneService.getAllRelazioni();
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/prodotto/{id}")
    public ResponseEntity<List<Optional<RelazioneProdottiIntervento>>> getRelazioniByProdotto(@PathVariable("id") int prodottoId){
        Prodotto prodotto = prodottoService.getProdottoById(prodottoId);
        List<Optional<RelazioneProdottiIntervento>> relazioni = relazioneService.getRelazioniByProdotto(prodotto);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/intervento/{id}")
    public ResponseEntity<List<Optional<RelazioneProdottiIntervento>>> getRelazioniByIntervento(@PathVariable("id") int interventoId){
        Intervento intervento = interventoService.getInterventoById(interventoId);
        List<Optional<RelazioneProdottiIntervento>> relazioni = relazioneService.getRelazioniByIntervento(intervento);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/ddt/{id}")
    public ResponseEntity<List<Optional<RelazioneProdottiIntervento>>> getRelazioniByDDT(@PathVariable("id") int ddtId){
        Ddt ddt = ddtService.getDdtById(ddtId);
        List<Optional<RelazioneProdottiIntervento>> relazioni = relazioneService.getRelazioniByDdt(ddt);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRelazione(@PathVariable("id") int relazioneId){
        relazioneService.deleteRelazione(relazioneId);
        return new ResponseEntity<>("Relazione successfully deleted!", HttpStatus.OK);
    }
}
