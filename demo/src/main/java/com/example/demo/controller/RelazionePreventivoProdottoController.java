package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Preventivo;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.RelazionePreventivoProdotto;
import com.example.demo.service.impl.RelazionePreventivoProdottoServiceImpl;
import com.example.demo.service.PreventivoService;
import com.example.demo.service.ProdottoService;
import java.io.IOException;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(value = "/api/relazionePreventivoProdotto")
public class RelazionePreventivoProdottoController {
    
    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private PreventivoService preventivoService;

    @Autowired
    private RelazionePreventivoProdottoServiceImpl relazioneService;


    @PostMapping
    public ResponseEntity<RelazionePreventivoProdotto> createRelazione(@RequestBody RelazionePreventivoProdotto relazione){
        RelazionePreventivoProdotto newRelazione = relazioneService.createRelazione(relazione);
        return new ResponseEntity<>(newRelazione, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RelazionePreventivoProdotto> getRelazioneById(@PathVariable("id") int relazioneId){
        RelazionePreventivoProdotto relazione = relazioneService.getRelazioneById(relazioneId);
        return new ResponseEntity<>(relazione, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RelazionePreventivoProdotto>> getAllRelazioni(){
        List<RelazionePreventivoProdotto> relazioni = relazioneService.getAllRelazioni();
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/prodotto/{id}")
    public ResponseEntity<List<Optional<RelazionePreventivoProdotto>>> getRelazioniByProdotto(@PathVariable("id") int prodottoId){
        Prodotto prodotto = prodottoService.getProdottoById(prodottoId);
        List<Optional<RelazionePreventivoProdotto>> relazioni = relazioneService.getRelazioniByProdotto(prodotto);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/preventivo/{id}")
    public ResponseEntity<List<Optional<RelazionePreventivoProdotto>>> getRelazioniByPreventivo(@PathVariable("id") int preventivoId){
        Preventivo preventivo = preventivoService.getPreventivoById(preventivoId);
        List<Optional<RelazionePreventivoProdotto>> relazioni = relazioneService.getRelazioniByPreventivo(preventivo);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<RelazionePreventivoProdotto> updateRelazione(@RequestBody RelazionePreventivoProdotto relazione) throws IOException{
        RelazionePreventivoProdotto updatedRelazione = relazioneService.updateRelazione(relazione);
        return new ResponseEntity<>(updatedRelazione, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRelazione(@PathVariable("id") int relazioneId){
        relazioneService.deleteRelazione(relazioneId);
        return new ResponseEntity<>("Relazione successfully deleted!", HttpStatus.OK);
    }
}
