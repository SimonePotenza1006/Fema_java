package com.example.demo.controller;

import com.example.demo.entity.Fornitore;
import com.example.demo.entity.Ruolo;
import com.example.demo.service.FornitoreService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/fornitore")
public class FornitoreController {
    
    private FornitoreService fornitoreService;

    @PostMapping
    public ResponseEntity<Fornitore> createFornitore(@RequestBody Fornitore fornitore){
    	Fornitore savedFornitore = fornitoreService.createFornitore(fornitore);
        return new ResponseEntity<>(savedFornitore, HttpStatus.CREATED);
    }

    // build get report by id REST API
    // http://localhost:8080/api/reports/1
    @GetMapping("{id}")
    public ResponseEntity<Fornitore> getFornitoreById(@PathVariable("id") int fornitoreId){
    	Fornitore fornitore = fornitoreService.getFornitoreById(fornitoreId);
        return new ResponseEntity<>(fornitore, HttpStatus.OK);
    }

    // Build Get All Reports REST API
    // http://localhost:8080/api/reports
    @GetMapping
    public ResponseEntity<List<Fornitore>> getAllFornitori(){
        List<Fornitore> fornitori = fornitoreService.getAllFornitori();
        return new ResponseEntity<>(fornitori, HttpStatus.OK);
    }

    // Build Update Report REST API
    @PutMapping//("{id}")
    // http://localhost:8080/api/reports/1
    public ResponseEntity<Fornitore> updateFornitore(@RequestBody Fornitore fornitore) throws IOException{
    	Fornitore updatedFornitore = fornitoreService.updateFornitore(fornitore);
        return new ResponseEntity<>(updatedFornitore, HttpStatus.OK);
    }

    // Build Delete Report REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFornitore(@PathVariable("id") int fornitoreId){
    	fornitoreService.deleteFornitore(fornitoreId);
        return new ResponseEntity<>("Fornitore successfully deleted!", HttpStatus.OK);
    }
}