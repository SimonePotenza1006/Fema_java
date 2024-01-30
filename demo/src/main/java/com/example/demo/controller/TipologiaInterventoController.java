package com.example.demo.controller;

import lombok.AllArgsConstructor;

import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.repository.TipologiaInterventoRepository;
import com.example.demo.service.TipologiaInterventoService;

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
@RequestMapping(value = "/api/tipologiaIntervento")
public class TipologiaInterventoController {
    
    TipologiaInterventoService tipologiaInterventoService;

    @PostMapping
    public ResponseEntity<TipologiaIntervento> createTipologiaIntervento(@RequestBody TipologiaIntervento tipologiaIntervento){
        TipologiaIntervento savedTipologiaIntervento = tipologiaInterventoService.createTipologiaIntervento(tipologiaIntervento);
        return new ResponseEntity<>(savedTipologiaIntervento, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TipologiaIntervento> getTipologiaById(@PathVariable("id") int tipologiaInterventoId){
        TipologiaIntervento tipologiaIntervento = tipologiaInterventoService.getTipologiaInterventoById(tipologiaInterventoId);
        return new ResponseEntity<>(tipologiaIntervento, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TipologiaIntervento>> getAllTipologieIntervento(){
        List<TipologiaIntervento> tipologieIntervento = tipologiaInterventoService.getAllTipologieIntervento();
        return new ResponseEntity<>(tipologieIntervento, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TipologiaIntervento> updateTipologiaIntervento(@RequestBody TipologiaIntervento tipologiaIntervento) throws IOException {
        TipologiaIntervento updatedTipologiaIntervento = tipologiaInterventoService.updateTipologiaIntervento(tipologiaIntervento);
        return new ResponseEntity<>(updatedTipologiaIntervento, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTipologiaIntervento(@PathVariable("id") int tipologiaInterventoId){
        tipologiaInterventoService.deleteTipologiaIntervento(tipologiaInterventoId);
        return new ResponseEntity<>("Tipologia intervento successfully deleted!", HttpStatus.OK);
    } 

}
