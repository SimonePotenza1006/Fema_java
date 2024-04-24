package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Ingresso;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Utente;
import com.example.demo.service.UtenteService;
import com.example.demo.service.impl.IngressoServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/ingresso")
public class IngressoController {
    
    @Autowired
    private IngressoServiceImpl ingressoService;

    @Autowired
    private UtenteService utenteService;

    @PostMapping
    public ResponseEntity<Ingresso> createIngresso(@RequestBody Ingresso ingresso){
        Ingresso savedIngresso = ingressoService.createIngresso(ingresso);
        return new ResponseEntity<>(savedIngresso, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ingresso> getIngressoById(@PathVariable("id") int ingressoId) {
        int idvariable = ingressoId;
        Ingresso ingresso = ingressoService.getIngressoById(idvariable);
        if (ingresso == null) {
            System.out.println("Ingresso non trovato con ID: " + ingressoId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Ingresso non trovato con ID: " + ingressoId);
        return new ResponseEntity<>(ingresso, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ingresso>> getAllIngressi(){
        List<Ingresso> ingressi = ingressoService.getAllIngressi();
        return new ResponseEntity<>(ingressi, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<Ingresso>> getAllIngressiOrderByDesc(){
        List<Ingresso> ingressi = ingressoService.getAllIngressiOrderByDesc();
        return new ResponseEntity<>(ingressi, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<Ingresso>>> getIngressiByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<Ingresso>> ingressi = ingressoService.getIngressiByUtente(utente);
        return new ResponseEntity<>(ingressi, HttpStatus.OK);
    }


}
