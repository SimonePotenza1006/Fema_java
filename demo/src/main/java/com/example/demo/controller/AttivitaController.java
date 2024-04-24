package com.example.demo.controller;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Attivita;
import com.example.demo.service.AttivitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/attivita")
public class AttivitaController {
    
    private AttivitaService attivitaService;

    @PostMapping
    public ResponseEntity<Attivita> createAttivita(@RequestBody Attivita attivita){
        Attivita savedAttivita = attivitaService.createAttivita(attivita);
        return new ResponseEntity<>(savedAttivita, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Attivita> getAttivitaById(@PathVariable("id") int atttivitaId){
    	Attivita attivita = attivitaService.getAttivitaById(atttivitaId);
        return new ResponseEntity<>(attivita, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Attivita>> getAllAttivita(){
        List<Attivita> attivita = attivitaService.getAllAttivita();
        return new ResponseEntity<>(attivita, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Attivita> updateAttivita(@RequestBody Attivita attivita) throws IOException{
    	Attivita updatedAttivita = attivitaService.updateAttivita(attivita);
        return new ResponseEntity<>(updatedAttivita, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAttivita(@PathVariable("id") int attivitaId){
    	attivitaService.deleteAttivita(attivitaId);
        return new ResponseEntity<>("Attivita successfully deleted!", HttpStatus.OK);
    }
}
