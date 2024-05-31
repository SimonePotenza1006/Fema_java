package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.PosizioniGps;
import com.example.demo.service.ClienteService;
import com.example.demo.service.PosizioniGpsService;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/posizioni")
public class PosizioniGpsController {
    
    @Autowired
    private PosizioniGpsService posizioneService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<PosizioniGps> createPosizione(@RequestBody PosizioniGps posizione){
        PosizioniGps savedPosizione = posizioneService.createPosizione(posizione);
        return new ResponseEntity<>(savedPosizione, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PosizioniGps> getPosizioneById(@PathVariable("id") int posizioneId){
        PosizioniGps posizione = posizioneService.getPosizioneById(posizioneId);
        return new ResponseEntity<>(posizione, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<PosizioniGps>> getAllNote(){
        List<PosizioniGps> posizioni = posizioneService.getAllPosizioniOrderByDesc();
        return new ResponseEntity<>(posizioni, HttpStatus.OK);
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<List<Optional<PosizioniGps>>> getPosizioniByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<Optional<PosizioniGps>> posizioni = posizioneService.getPosizioneByCliente(cliente);
        return new ResponseEntity<>(posizioni, HttpStatus.OK); 
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int posizioneId){
        posizioneService.deletePosizione(posizioneId);
        return new ResponseEntity<>("Posizione eliminata", HttpStatus.OK);
    }
}
