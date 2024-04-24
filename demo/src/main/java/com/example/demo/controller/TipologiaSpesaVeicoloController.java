package com.example.demo.controller;
import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.TipologiaSpesaVeicolo;
import com.example.demo.service.TipologiaSpesaVeicoloService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/tipologiaSpesaVeicolo")
public class TipologiaSpesaVeicoloController {
    
    private TipologiaSpesaVeicoloService tipologiaService;

    @PostMapping
    public ResponseEntity<TipologiaSpesaVeicolo> createTipologia(@RequestBody TipologiaSpesaVeicolo tipologia){
        TipologiaSpesaVeicolo tipologiaSpesaVeicolo = tipologiaService.createTipologia(tipologia);
        return new ResponseEntity<>(tipologiaSpesaVeicolo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TipologiaSpesaVeicolo> getTipologiaById(@PathVariable("id") int tipologiaId){
        TipologiaSpesaVeicolo tipologia = tipologiaService.getTipologiaSpesaVeicoloById(tipologiaId);
        return new ResponseEntity<>(tipologia, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TipologiaSpesaVeicolo>> getAllTipologie() {
        List<TipologiaSpesaVeicolo> tipologie = tipologiaService.getAllTipologie();
        return new ResponseEntity<>(tipologie, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TipologiaSpesaVeicolo> updateTipologia(@RequestBody TipologiaSpesaVeicolo tipologia){
        TipologiaSpesaVeicolo UpdatedTipologia = tipologiaService.updateTipologia(tipologia);
        return new ResponseEntity<>(UpdatedTipologia, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTipologia(@PathVariable("id") int tipologiaId){
        tipologiaService.deleteTipologia(tipologiaId);
        return new ResponseEntity<>("Tipologia di spesa su veicolo succesfully deleted", HttpStatus.OK);
    }
}
