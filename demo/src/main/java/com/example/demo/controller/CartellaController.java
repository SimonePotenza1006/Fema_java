package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cartella;
import com.example.demo.service.CartellaService;

import java.io.IOException;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/cartella")
public class CartellaController {
    
    @Autowired
    private CartellaService cartellaService;

    @PostMapping
    public ResponseEntity<Cartella> createCartella(@RequestBody Cartella cartella){
        Cartella savedCartella = cartellaService.createCartella(cartella);
        return new ResponseEntity<>(savedCartella, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cartella> getCartellaById(@PathVariable("id") int cartellaId){
        Cartella cartella = cartellaService.getCartellaById(cartellaId);
        return new ResponseEntity<>(cartella, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cartella>> getAllCartelle(){
        List<Cartella> cartelle = cartellaService.getAllCartelle();
        return new ResponseEntity<>(cartelle, HttpStatus.OK);
    }

    @GetMapping("/parent/{id}")
    public ResponseEntity<List<Cartella>> getCartellaByParentFolder(@PathVariable("id") int cartellaId){
        Cartella cartella = cartellaService.getCartellaById(cartellaId);
        List<Cartella> cartelle = cartellaService.getCartelleByParentFolder(cartella);
        return new ResponseEntity<>(cartelle, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cartella> updateCartella(@RequestBody Cartella cartella) throws IOException{
        Cartella updatedCartella = cartellaService.updateCartella(cartella);
        return new ResponseEntity<>(updatedCartella, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCartella(@PathVariable("id") int cartellaId){
        cartellaService.deleteCartella(cartellaId);
        return new ResponseEntity<>("Cartella successfully deleted", HttpStatus.OK);
    }
}
