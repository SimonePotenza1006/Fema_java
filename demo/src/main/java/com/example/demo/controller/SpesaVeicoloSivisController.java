package com.example.demo.controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.SpesaVeicoloSivis;
import com.example.demo.service.impl.SpesaVeicoloSivisServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/spesaVeicoloSivis")
public class SpesaVeicoloSivisController {

    @Autowired
    SpesaVeicoloSivisServiceImpl spesaService;
    
    @PostMapping
    public ResponseEntity<SpesaVeicoloSivis> createSpesa(@RequestBody SpesaVeicoloSivis spesa){
        SpesaVeicoloSivis savedSpesa = spesaService.createSpesa(spesa);
        return new ResponseEntity<>(savedSpesa, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SpesaVeicoloSivis> getSpesaVeicoloById(@PathVariable("id") int spesaVeicoloId) {
        int idvariable = spesaVeicoloId;
        SpesaVeicoloSivis spesaVeicolo = spesaService.getSpesaById(idvariable);
        if (spesaVeicolo == null) {
            System.out.println("Spesa non trovato con ID: " + spesaVeicoloId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(spesaVeicolo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SpesaVeicoloSivis>> getAllSpeseVeicolo(){
        List<SpesaVeicoloSivis> spese = spesaService.getAllSpese();
        return new ResponseEntity<>(spese, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<SpesaVeicoloSivis> updateSpesa(@RequestBody SpesaVeicoloSivis spesa) throws IOException{
        SpesaVeicoloSivis updatedSpesa = spesaService.updateSpesa(spesa);
        return new ResponseEntity<>(updatedSpesa, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSpesa(@PathVariable("id") int spesaId){
        spesaService.deleteSpesa(spesaId);
        return new ResponseEntity<>("Spesa successfully deleted!", HttpStatus.OK);
    }
}
