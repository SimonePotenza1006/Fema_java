package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.GruppoInterventi;
import com.example.demo.service.ClienteService;
import com.example.demo.service.impl.GruppoInterventiServiceImpl;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/gruppi")
public class GruppoInterventiController {
    
    @Autowired
    private GruppoInterventiServiceImpl gruppoService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<GruppoInterventi> createGruppo(@RequestBody GruppoInterventi gruppo){
        GruppoInterventi savedGruppo = gruppoService.createGruppo(gruppo);
        return new ResponseEntity<>(savedGruppo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<GruppoInterventi> getGruppoById(@PathVariable("id") int gruppoId){
        GruppoInterventi gruppo = gruppoService.getGruppoById(gruppoId);
        return new ResponseEntity<>(gruppo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GruppoInterventi>> getAllGruppi(){
        List<GruppoInterventi> gruppi = gruppoService.getAllGruppiIntervento();
        return new ResponseEntity<>(gruppi, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<GruppoInterventi>> getAllGruppiOrderByDesc(){
        List<GruppoInterventi> gruppi = gruppoService.getAllGruppiOrderedByDesc();
        return new ResponseEntity<>(gruppi, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Optional<GruppoInterventi>>> getGruppiByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<Optional<GruppoInterventi>> gruppi = gruppoService.getGruppiByCliente(cliente);
        return new ResponseEntity<>(gruppi, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteIntervento(@PathVariable("id") int gruppoId){
        gruppoService.deleteGruppo(gruppoId);
        return new ResponseEntity<>("Gruppo di interventi successfully deleted!", HttpStatus.OK);
    }



}
