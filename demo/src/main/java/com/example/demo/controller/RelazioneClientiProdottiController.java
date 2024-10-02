package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.RelazioneClientiProdotti;
import com.example.demo.service.ClienteService;
import com.example.demo.service.ProdottoService;
import com.example.demo.service.impl.RelazioneClientiProdottiServiceImpl;

@RestController
@RequestMapping(value = "/api/relazioniClientiProdotti")
public class RelazioneClientiProdottiController {
    
    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private RelazioneClientiProdottiServiceImpl relazioneService;

    @PostMapping
    public ResponseEntity<RelazioneClientiProdotti> createRelazione(@RequestBody RelazioneClientiProdotti relazione){
        RelazioneClientiProdotti newRelazione = relazioneService.createRelazione(relazione);
        return new ResponseEntity<>(newRelazione, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RelazioneClientiProdotti> getRelazioneById(@PathVariable("id") int relazioneId){
        RelazioneClientiProdotti relazione = relazioneService.getRelazioneById(relazioneId);
        return new ResponseEntity<>(relazione, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RelazioneClientiProdotti>> getAllRelazioni(){
        List<RelazioneClientiProdotti> relazioni = relazioneService.getAllRelazioni();
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<List<RelazioneClientiProdotti>> getRelazioniByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<RelazioneClientiProdotti> relazioni = relazioneService.getAllRelazioniByCliente(cliente);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("prodotto/{id}")
    public ResponseEntity<List<RelazioneClientiProdotti>> getRelazioniByProdott(@PathVariable("id") int prodottoId){
        Prodotto prodotto = prodottoService.getProdottoById(prodottoId);
        List<RelazioneClientiProdotti> relazioni= relazioneService.getAllRelazioniByProdotto(prodotto);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRelazione(@PathVariable("id") int relazioneId){
        relazioneService.deleteRelazione(relazioneId);
        return new ResponseEntity<>("Relazione succesfully deleted!", HttpStatus.OK);
    }
}
