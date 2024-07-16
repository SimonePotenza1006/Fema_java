package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.OrdinePerIntervento;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Utente;
import com.example.demo.service.OrdinePerInterventoService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.ClienteService;
import com.example.demo.service.InterventoService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/ordine")
public class OrdinePerInterventoController {

    @Autowired
    private OrdinePerInterventoService ordineService;

    @Autowired
    private InterventoService interventoService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<OrdinePerIntervento> createOrdine(@RequestBody OrdinePerIntervento ordine){
        OrdinePerIntervento savedOrdine = ordineService.createOrdine(ordine);
        return new ResponseEntity<>(savedOrdine, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrdinePerIntervento> getOrdineById(@PathVariable("id") int ordineId){
        OrdinePerIntervento ordine = ordineService.getOrdineById(ordineId);
        return new ResponseEntity<>(ordine, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrdinePerIntervento>> getAllOrdini(){
        List<OrdinePerIntervento> ordini = ordineService.getAllOrdini();
        return new ResponseEntity<>(ordini, HttpStatus.OK);
    }

    @GetMapping("/ordered")
    public ResponseEntity<List<OrdinePerIntervento>> getAllOrdiniOrderByDesc(){
        List<OrdinePerIntervento> ordini = ordineService.getAllOrdiniOrderByDesc();
        return new ResponseEntity<>(ordini, HttpStatus.OK);
    }

    @GetMapping("/intervento/{id}")
    public ResponseEntity<List<Optional<OrdinePerIntervento>>> getOrdineByIntervento(@PathVariable("id") int interventoId){
        Intervento intervento = interventoService.getInterventoById(interventoId);
        List<Optional<OrdinePerIntervento>> ordini = ordineService.getOrdineByIntervento(intervento);
        return new ResponseEntity<>(ordini, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<OrdinePerIntervento>>> getOrdineByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<OrdinePerIntervento>> ordini = ordineService.getOrdineByUtente(utente);
        return new ResponseEntity<>(ordini, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Optional<OrdinePerIntervento>>> getOrdineByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<Optional<OrdinePerIntervento>> ordini = ordineService.getOrdineByCliente(cliente);
        return new ResponseEntity<>(ordini, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrdinePerIntervento> updateOrdine(@RequestBody OrdinePerIntervento ordine) throws IOException{
        OrdinePerIntervento updatedOrdine = ordineService.updateOrdine(ordine);
        return new ResponseEntity<>(updatedOrdine, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrdine(@PathVariable("id") int ordineId){
        ordineService.deleteOrdine(ordineId);
        return new ResponseEntity<>("Ordine successfully deleted!", HttpStatus.OK);
    }


}
