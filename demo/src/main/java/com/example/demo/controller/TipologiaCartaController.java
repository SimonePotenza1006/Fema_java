package com.example.demo.controller;

import lombok.AllArgsConstructor;

import com.example.demo.entity.TipologiaCarta;
import com.example.demo.entity.CartaDiCredito;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente;
import com.example.demo.service.CartaDiCreditoService;
import com.example.demo.service.TipologiaCartaService;
import com.example.demo.service.RuoloService;
import com.example.demo.service.UtenteService;

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
@RequestMapping(value = "/api/tipologiacarta")
public class TipologiaCartaController {
    
    private TipologiaCartaService tipologiaCartaService;

    @PostMapping
    public ResponseEntity<TipologiaCarta> createTipologia(@RequestBody TipologiaCarta tipologiaCarta){
        TipologiaCarta savedTipologiaCarta = tipologiaCartaService.createTipologiaCarta(tipologiaCarta);
        return new ResponseEntity<>(savedTipologiaCarta, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TipologiaCarta> getTipologiaCartaById(@PathVariable("id") int tipologiaCartaId){
        TipologiaCarta tipologia = tipologiaCartaService.getTipologiaCartaById(tipologiaCartaId);
        return new ResponseEntity<>(tipologia, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TipologiaCarta>> getAllTipologieCarta(){
        List<TipologiaCarta> tipologie = tipologiaCartaService.getAllTipologieCarta();
        return new ResponseEntity<>(tipologie, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TipologiaCarta> updateTipologia(@RequestBody TipologiaCarta tipologiaCarta) throws IOException {
        TipologiaCarta updateTipologia = tipologiaCartaService.updateTipologiaCarta(tipologiaCarta);
        return new ResponseEntity<>(updateTipologia, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTipologiaCarta(@PathVariable("id") int tipologiaCartaId){
        tipologiaCartaService.deleteTipologiaCarta(tipologiaCartaId);
        return new ResponseEntity<>("Tipologia di carta successfully deleted!", HttpStatus.OK);
    }
}
