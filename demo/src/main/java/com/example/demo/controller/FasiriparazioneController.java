package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FasiRiparazione;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.service.MerceInRiparazioneService;
import com.example.demo.service.impl.FasiRiparazioneServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/fasi")
public class FasiriparazioneController {
    
    @Autowired
    private FasiRiparazioneServiceImpl fasiService;

    @Autowired
    private MerceInRiparazioneService merceService;

    @PostMapping
    public ResponseEntity<FasiRiparazione> createFase(@RequestBody FasiRiparazione fase){
        FasiRiparazione savedFase = fasiService.createFase(fase);
        return new ResponseEntity<>(savedFase, HttpStatus.CREATED);
    }

    @GetMapping("/merce/{id}")
    public ResponseEntity<List<FasiRiparazione>> getFasiByMerce(@PathVariable("id") int merceId){
        MerceInRiparazione merce = merceService.getMerceById(merceId);
        List<FasiRiparazione> fasi = fasiService.getFasiByMerce(merce);
        return new ResponseEntity<>(fasi, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFase(@PathVariable("id") int faseId){
        fasiService.deleteFase(faseId);
        return new ResponseEntity<>("Fase successfully deleted!", HttpStatus.OK);
    }
}
