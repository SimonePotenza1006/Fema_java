package com.example.demo.controller;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.service.InterventoService;
import com.example.demo.service.TipologiaInterventoService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.impl.InterventoServiceImpl;
import com.example.demo.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/intervento")
public class InterventoController {

    @Autowired
    private InterventoServiceImpl interventoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private TipologiaInterventoService tipologiaInterventoService;

    @PostMapping
    public ResponseEntity<Intervento> createIntervento(@RequestBody Intervento intervento){
        Intervento savedIntervento = interventoService.createIntervento(intervento);
        return new ResponseEntity<>(savedIntervento, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Intervento> getInterventoById(@PathVariable("id") int interventoId) {
        int idvariable = interventoId;
        System.out.println("Prova getInterventoById per ID: " + interventoId);
        Intervento intervento = interventoService.getInterventoById(idvariable);
        if (intervento == null) {
            System.out.println("Intervento non trovato con ID: " + interventoId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Intervento non trovato con ID: " + interventoId);
        return new ResponseEntity<>(intervento, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Intervento>> getAllInterventi(){
        List<Intervento> interventi = interventoService.getAllInterventi();
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Optional<Intervento>>> getInterventiByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<Optional<Intervento>> interventi = interventoService.getInterventoByCliente(cliente);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("/categoriaIntervento/{id}")
    public ResponseEntity<List<Optional<Intervento>>> getInterventoByTipologia(@PathVariable("id") int tipologiaId){
        TipologiaIntervento tipologia = tipologiaInterventoService.getTipologiaInterventoById(tipologiaId);
        List<Optional<Intervento>> interventi = interventoService.getInterventoByTipologia(tipologia);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<Intervento>>> getInterventoByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<Intervento>> interventi = interventoService.getInterventoByUtente(utente);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Intervento> updateIntervento(@RequestBody Intervento intervento) throws IOException{
        Intervento updatedIntervento = interventoService.updateIntervento(intervento);
        return new ResponseEntity<>(updatedIntervento, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteIntervento(@PathVariable("id") int interventoId){
        interventoService.deleteIntervento(interventoId);
        return new ResponseEntity<>("Intervento successfully deleted!", HttpStatus.OK);
    }



}