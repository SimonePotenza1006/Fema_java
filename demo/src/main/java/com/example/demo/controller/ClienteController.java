package com.example.demo.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
    	Cliente savedCliente = clienteService.createCliente(cliente);
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") int clienteId){
        System.out.println("Prova");
    	Cliente cliente = clienteService.getClienteById(clienteId);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClienti(){
        List<Cliente> clienti = clienteService.getAllClienti();
        return new ResponseEntity<>(clienti, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) throws IOException{
        System.out.println("AOOOOOOOOOOOOO");
    	Cliente updatedCliente = clienteService.updateCliente(cliente);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable("id") int clienteId){
    	clienteService.deleteCliente(clienteId);
        return new ResponseEntity<>("Cliente successfully deleted!", HttpStatus.OK);
    }
}
