package com.example.demo.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CredenzialiCliente;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.service.CredenzialiClienteService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.ClienteService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/credenziali")
public class CredenzialiClienteController {
    
    @Autowired
    private CredenzialiClienteService credenzialiService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<CredenzialiCliente> createCredenzialiCliente(@RequestBody CredenzialiCliente credenziali){
        CredenzialiCliente savedCredenziali = credenzialiService.createCredenzialiCliente(credenziali);
        return new ResponseEntity<>(savedCredenziali, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CredenzialiCliente> getCredenzialiById(@PathVariable("id") int credenzialiId){
        CredenzialiCliente credenziali = credenzialiService.getCredenzialiClienteById(credenzialiId);
        return new ResponseEntity<>(credenziali, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CredenzialiCliente>> getAllCredenziali(){
        List<CredenzialiCliente> credenziali = credenzialiService.getAllCredenzialiClienti();
        return new ResponseEntity<>(credenziali, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<CredenzialiCliente>> getCredenzialiByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<CredenzialiCliente> credenziali = credenzialiService.getCredenzialiByUtente(utente)
                                    .stream()
                                    .filter(Optional::isPresent)
                                    .map(Optional::get)
                                    .collect(Collectors.toList());
        return new ResponseEntity<>(credenziali, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<CredenzialiCliente>> getCredenzialiByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<CredenzialiCliente> credenziali = credenzialiService.getCredenzialiByCliente(cliente)
                                    .stream()
                                    .filter(Optional::isPresent)
                                    .map(Optional::get)
                                    .collect(Collectors.toList());
        return new ResponseEntity<>(credenziali, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CredenzialiCliente> updateCredenzialiCliente(@RequestBody CredenzialiCliente credenziali) throws IOException{
        CredenzialiCliente updatedCredenziale = credenzialiService.updateCredenzialiCliente(credenziali);
        return new ResponseEntity<>(updatedCredenziale, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCredenzialiCliente(@PathVariable("id") int credenzialiId){
        credenzialiService.deleteCredenzialiCliente(credenzialiId);
        return new ResponseEntity<>("Credenziali successfully deleted", HttpStatus.OK);
    }
}
