package com.example.demo.controller;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Viaggio;
import com.example.demo.entity.Spesa;
import com.example.demo.service.ViaggioService;
import com.example.demo.service.SpesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/spesa")
public class SpesaController {
    
    private SpesaService spesaService;
    private ViaggioService viaggioService;

    @PostMapping
    public ResponseEntity<Spesa> createSpesa(@RequestBody Spesa spesa){
    	Spesa savedSpesa = spesaService.createSpesa(spesa);
        return new ResponseEntity<>(savedSpesa, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Spesa> getSpesaById(@PathVariable("id") int viaggioId){
    	Spesa viaggio = spesaService.getSpesaById(viaggioId);
        return new ResponseEntity<>(viaggio, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Spesa>> getAllSpese(){
        List<Spesa> spese = spesaService.getAllSpese();
        return new ResponseEntity<>(spese, HttpStatus.OK);
    }

    @GetMapping("/viaggio/{id}")
    public ResponseEntity<List<Optional<Spesa>>> getSpeseByViaggio(@PathVariable("id") int viaggioId){
    	Viaggio viaggio = viaggioService.getViaggioById(viaggioId);
        List<Optional<Spesa>> spesePerViaggio = spesaService.getSpesaByViaggio(viaggio);
        return new ResponseEntity<>(spesePerViaggio, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Spesa> updateSpesa(@RequestBody Spesa viaggio) throws IOException{
    	Spesa updatedSpesa = spesaService.updateSpesa(viaggio);
        return new ResponseEntity<>(updatedSpesa, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteViaggio(@PathVariable("id") int spesaId){
    	spesaService.deleteSpesa(spesaId);
        return new ResponseEntity<>("Spesa successfully deleted!", HttpStatus.OK);
    }
}
