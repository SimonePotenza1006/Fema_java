package com.example.demo.controller;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TipologiaMovimento;
import com.example.demo.repository.TipologiaMovimentoRepository;
import com.example.demo.service.TipologiaMovimentoService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/tipologiaMovimento")
public class TipologiaMovimentoController {
    
    @Autowired
    private TipologiaMovimentoRepository tipologiaRepository;

    @Autowired
    private TipologiaMovimentoService tipologiaService;

    @PostMapping
    public ResponseEntity<TipologiaMovimento> createTipologia(@RequestBody TipologiaMovimento tipologia){
        TipologiaMovimento savedTipologia = tipologiaService.createTipologia(tipologia);
        return new ResponseEntity<>(savedTipologia, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TipologiaMovimento>> getAllTipologie(){
        List<TipologiaMovimento> tipologie = tipologiaService.getAllTipologie();
        return new ResponseEntity<>(tipologie, HttpStatus.OK);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<TipologiaMovimento> updateTipologia(@RequestBody TipologiaMovimento tipologia){
        TipologiaMovimento updatedTipologia = tipologiaService.updateTipologia(tipologia);
        return new ResponseEntity<>(updatedTipologia, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTipologia(@PathVariable("id") int tipologiaId){
        tipologiaService.deleteTipologia(tipologiaId);
        return new ResponseEntity<>("Tipologia succesfully deleted", HttpStatus.OK);
    }

}
