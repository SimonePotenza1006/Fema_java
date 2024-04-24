package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.service.UtenteService;
import com.example.demo.entity.Utente;
import com.example.demo.service.impl.MerceInRiparazioneServiceImpl;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/merceInRiparazione")
public class MerceInRiparazioneController {
    
    @Autowired
    private MerceInRiparazioneServiceImpl merceService;

    @Autowired
    private UtenteService utenteService;

    @PostMapping
    public ResponseEntity<MerceInRiparazione> createMerce(@RequestBody MerceInRiparazione merce){
        MerceInRiparazione savedMerce = merceService.createMerce(merce);
        return new ResponseEntity<>(savedMerce, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MerceInRiparazione> getMerceById(@PathVariable("id") int merceId) {
        int idvariable = merceId;
        MerceInRiparazione merce = merceService.getMerceById(idvariable);
        if (merce == null) {
            System.out.println("Merce non trovata con ID: " + merceId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Merce non trovata con ID: " + merceId);
        return new ResponseEntity<>(merce, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MerceInRiparazione>> getAllMerci(){
        List<MerceInRiparazione> merci = merceService.getAllMerce();
        return new ResponseEntity<>(merci, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<MerceInRiparazione>> getAllMerciOrderByDesc(){
        List<MerceInRiparazione> merci = merceService.getAllMerciOrderByIdDesc();
        return new ResponseEntity<>(merci, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<MerceInRiparazione>>> getMerceByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<MerceInRiparazione>> merci = merceService.getMerciByUtente(utente);
        return new ResponseEntity<>(merci, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMerce(@PathVariable("id") int merceId){
        merceService.deleteMerce(merceId);
        return new ResponseEntity<>("Merce successfully deleted!", HttpStatus.OK);
    }
}
