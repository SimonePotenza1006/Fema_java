package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Scadenza;
import com.example.demo.service.ClienteService;
import com.example.demo.service.impl.ScadenzaServiceImpl;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/scadenza")
public class ScadenzaController {
    
    @Autowired
    private ScadenzaServiceImpl scadenzaService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Scadenza> createScadenza(@RequestBody Scadenza scadenza){
        Scadenza savedScadenza = scadenzaService.createScadenza(scadenza);
        return new ResponseEntity<>(savedScadenza, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Scadenza> getScadenzaById(@PathVariable("id") int scadenzaId){
        Scadenza scadenza = scadenzaService.getScadenzaById(scadenzaId);
        return new ResponseEntity<>(scadenza, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<Scadenza>> getAllScadenzaOrderByDesc(){
        List<Scadenza> scadenze = scadenzaService.getAllScadenzeOrderByDesc();
        return new ResponseEntity<>(scadenze, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Scadenza>> getAllScadenze(){
        List<Scadenza> scadenze = scadenzaService.getAllScadenze();
        return new ResponseEntity<>(scadenze, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Optional<Scadenza>>> getScadenzaByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<Optional<Scadenza>> scadenze = scadenzaService.getScadenzaByCliente(cliente);
        return new ResponseEntity<>(scadenze, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteScadenza(int scadenzaId){
        scadenzaService.deleteScadenza(scadenzaId);
        return new ResponseEntity<>("Scadenza successfully deleted!", HttpStatus.OK);
    }
}
