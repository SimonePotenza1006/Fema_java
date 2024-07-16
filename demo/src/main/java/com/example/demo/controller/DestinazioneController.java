package com.example.demo.controller;


import lombok.RequiredArgsConstructor;

import com.example.demo.entity.Destinazione;
import com.example.demo.entity.Cliente;
import com.example.demo.service.DestinazioneService;
import com.example.demo.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/destinazione")
public class DestinazioneController {
    
    private final DestinazioneService destinazioneService;

    @Autowired
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Destinazione> createDestinazione(@RequestBody Destinazione destinazione){
    	Destinazione savedDestinazione = destinazioneService.createDestinazione(destinazione);
        return new ResponseEntity<>(savedDestinazione, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Destinazione> getDestinazioneById(@PathVariable("id") int destinazioneId){
    	Destinazione destinazione = destinazioneService.getDestinazioneById(destinazioneId);
        return new ResponseEntity<>(destinazione, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Destinazione>> getAllDestinazioni(){
        List<Destinazione> destinazioni = destinazioneService.getAllDestinazioni();
        return new ResponseEntity<>(destinazioni, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Optional<Destinazione>>> getDestinazioneByCliente(@PathVariable("id") int clienteId) {
        Cliente cliente = clienteService.getClienteById(clienteId);
        if (cliente != null) {
            List<Optional<Destinazione>> destinazioni = destinazioneService.getDestinazioneByCliente(cliente);
            return new ResponseEntity<>(destinazioni, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Destinazione> updateDestinazione(@RequestBody Destinazione destinazione) throws IOException{
        System.out.println("Prova DESTINAZIONE");
        Destinazione updatedDestinazione = destinazioneService.updateDestinazione(destinazione);
        return new ResponseEntity<>(updatedDestinazione, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDestinazione(@PathVariable("id") int destinazioneId){
    	destinazioneService.deleteDestinazione(destinazioneId);
        return new ResponseEntity<>("Destinazione successfully deleted!", HttpStatus.OK);
    }
}
