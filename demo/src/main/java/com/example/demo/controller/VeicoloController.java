package com.example.demo.controller;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Veicolo;
import com.example.demo.service.VeicoloService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/veicolo")
public class VeicoloController {
    
    private VeicoloService veicoloService;

    @PostMapping
    public ResponseEntity<Veicolo> createVeicolo(@RequestBody Veicolo veicolo){
    	Veicolo savedVeicolo = veicoloService.createVeicolo(veicolo);
        return new ResponseEntity<>(savedVeicolo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Veicolo> getVeicoloById(@PathVariable("id") int veicoloId){
    	Veicolo veicolo = veicoloService.getVeicoloById(veicoloId);
        return new ResponseEntity<>(veicolo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Veicolo>> getAllVeicoli(){
        List<Veicolo> veicoli = veicoloService.getAllVeicoli();
        return new ResponseEntity<>(veicoli, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    public ResponseEntity<Veicolo> updateVeicolo(@RequestBody Veicolo veicolo) throws IOException{
    	Veicolo updatedVeicolo = veicoloService.updateVeicolo(veicolo);
        return new ResponseEntity<>(updatedVeicolo, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVeicolo(@PathVariable("id") int veicoloId){
    	veicoloService.deleteVeicolo(veicoloId);
        return new ResponseEntity<>("Veicolo successfully deleted!", HttpStatus.OK);
    }

}
