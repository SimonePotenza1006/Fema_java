package com.example.demo.controller;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.service.AziendaService;
import com.example.demo.entity.Azienda;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/azienda")
public class AziendaController {
    
    @Autowired
    private AziendaService aziendaService;

    @PostMapping
    public ResponseEntity<Azienda> createAzienda(@RequestBody Azienda azienda){
    	Azienda savedAzienda = aziendaService.createAzienda(azienda);
        return new ResponseEntity<>(savedAzienda, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Azienda> getAziendaById(@PathVariable("id") int aziendaId){
        System.out.println("Prova");
    	Azienda azienda = aziendaService.getAziendaById(aziendaId);
        return new ResponseEntity<>(azienda, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Azienda>> getAllAziende(){
        List<Azienda> aziende = aziendaService.getAllAziende();
        return new ResponseEntity<>(aziende, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Azienda> updateAzienda(@RequestBody Azienda azienda) throws IOException{
        System.out.println("AOOOOOOOOOOOOO");
    	Azienda updatedAzienda = aziendaService.updateAzienda(azienda);
        return new ResponseEntity<>(updatedAzienda, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAzienda(@PathVariable("id") int aziendaId){
    	aziendaService.deleteAzienda(aziendaId);
        return new ResponseEntity<>("Azienda successfully deleted!", HttpStatus.OK);
    }
}
