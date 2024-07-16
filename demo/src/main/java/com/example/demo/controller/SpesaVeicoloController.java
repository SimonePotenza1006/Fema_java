package com.example.demo.controller;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SpesaVeicolo;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Veicolo;
import com.example.demo.service.SpesaVeicoloService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.VeicoloService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/spesaVeicolo")
public class SpesaVeicoloController {
    
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private VeicoloService veicoloService;

    @Autowired
    private SpesaVeicoloService spesaService;

    @PostMapping
    public ResponseEntity<SpesaVeicolo> createSpesa(@RequestBody SpesaVeicolo spesa){
        SpesaVeicolo savedSpesa = spesaService.createSpesa(spesa);
        return new ResponseEntity<>(savedSpesa, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SpesaVeicolo> getSpesaVeicoloById(@PathVariable("id") int spesaVeicoloId) {
        int idvariable = spesaVeicoloId;
        SpesaVeicolo spesaVeicolo = spesaService.getSpesaById(idvariable);
        if (spesaVeicolo == null) {
            System.out.println("Spesa non trovato con ID: " + spesaVeicoloId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(spesaVeicolo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SpesaVeicolo>> getAllSpeseVeicolo(){
        List<SpesaVeicolo> spese = spesaService.getAllSpese();
        return new ResponseEntity<>(spese, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<SpesaVeicolo>> getAllSpesaVeicoloOrderByDesc(){
        List<SpesaVeicolo> spese = spesaService.getAllSpesaVeicoloOrderByDesc();
        return new ResponseEntity<>(spese, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<SpesaVeicolo>>> getSpeseByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<SpesaVeicolo>> spese = spesaService.getSpeseVeicoloByUtente(utente);
        return new ResponseEntity<>(spese, HttpStatus.OK);
    }

    @GetMapping("/veicolo/{id}")
    public ResponseEntity<List<Optional<SpesaVeicolo>>> getSpeseByVeicolo(@PathVariable("id") int veicoloId){
        Veicolo veicolo = veicoloService.getVeicoloById(veicoloId);
        List<Optional<SpesaVeicolo>> spese = spesaService.getSpeseVeicoloByVeicolo(veicolo);
        return new ResponseEntity<>(spese, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<SpesaVeicolo> updateSpesa(@RequestBody SpesaVeicolo spesa) throws IOException{
        SpesaVeicolo updatedSpesa = spesaService.updateSpesa(spesa);
        return new ResponseEntity<>(updatedSpesa, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSpesa(@PathVariable("id") int spesaId){
        spesaService.deleteSpesa(spesaId);
        return new ResponseEntity<>("Spesa successfully deleted!", HttpStatus.OK);
    }
}
