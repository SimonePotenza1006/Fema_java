package com.example.demo.controller;
import lombok.AllArgsConstructor;

import com.example.demo.entity.Veicolo;
import com.example.demo.entity.VeicoloSivis;
import com.example.demo.service.VeicoloService;
import com.example.demo.service.VeicoloSivisService;

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
@RequestMapping(value = "/api/veicoloSivis")
public class VeicoloSivisController {
    
    private VeicoloSivisService veicoloService;

    @PostMapping
    public ResponseEntity<VeicoloSivis> createVeicolo(@RequestBody VeicoloSivis veicolo){
    	VeicoloSivis savedVeicolo = veicoloService.createVeicolo(veicolo);
        return new ResponseEntity<>(savedVeicolo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<VeicoloSivis> getVeicoloById(@PathVariable("id") int veicoloId){
    	VeicoloSivis veicolo = veicoloService.getVeicoloById(veicoloId);
        return new ResponseEntity<>(veicolo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VeicoloSivis>> getAllVeicoli(){
        List<VeicoloSivis> veicoli = veicoloService.getAllVeicoli();
        return new ResponseEntity<>(veicoli, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    public ResponseEntity<VeicoloSivis> updateVeicolo(@RequestBody VeicoloSivis veicolo) throws IOException{
    	VeicoloSivis updatedVeicolo = veicoloService.updateVeicolo(veicolo);
        return new ResponseEntity<>(updatedVeicolo, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVeicolo(@PathVariable("id") int veicoloId){
    	veicoloService.deleteVeicolo(veicoloId);
        return new ResponseEntity<>("Veicolo successfully deleted!", HttpStatus.OK);
    }
}
