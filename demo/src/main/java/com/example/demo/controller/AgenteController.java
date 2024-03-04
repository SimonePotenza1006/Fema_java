package com.example.demo.controller;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Agente;
import com.example.demo.entity.Cliente;
import com.example.demo.service.AgenteService;
import com.example.demo.service.ClienteService;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/agente")
public class AgenteController {
    
    @Autowired
    private AgenteService agenteService;

    @PostMapping
    public ResponseEntity<Agente> createAgente(@RequestBody Agente agente){
    	Agente savedAgente = agenteService.createAgente(agente);
        return new ResponseEntity<>(savedAgente, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Agente> getAgenteById(@PathVariable("id") int agenteId){
        System.out.println("Prova");
    	Agente agente = agenteService.getAgenteById(agenteId);
        return new ResponseEntity<>(agente, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Agente>> getAllAgenti(){
        List<Agente> agenti = agenteService.getAllAgenti();
        return new ResponseEntity<>(agenti, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Agente> updateAgente(@RequestBody Agente agente) throws IOException{
        System.out.println("AOOOOOOOOOOOOO");
    	Agente updatedAgente = agenteService.updateAgente(agente);
        return new ResponseEntity<>(updatedAgente, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAgente(@PathVariable("id") int agenteId){
    	agenteService.deleteAgente(agenteId);
        return new ResponseEntity<>("Agente successfully deleted!", HttpStatus.OK);
    }
}
