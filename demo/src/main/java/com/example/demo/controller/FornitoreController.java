package com.example.demo.controller;

import com.example.demo.entity.Fornitore;
import com.example.demo.service.impl.FornitoreServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/fornitore")
public class FornitoreController {
    
    private FornitoreServiceImpl fornitoreService;

    @PostMapping
    public ResponseEntity<Fornitore> createFornitore(@RequestBody Fornitore fornitore){
    	Fornitore savedFornitore = fornitoreService.createFornitore(fornitore);
        return new ResponseEntity<>(savedFornitore, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Fornitore> getFornitoreById(@PathVariable("id") int fornitoreId){
    	Fornitore fornitore = fornitoreService.getFornitoreById(fornitoreId);
        return new ResponseEntity<>(fornitore, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Fornitore>> getAllFornitori(){
        List<Fornitore> fornitori = fornitoreService.getAllFornitori();
        return new ResponseEntity<>(fornitori, HttpStatus.OK);
    }
    
    @PutMapping//("{id}")
    // http://localhost:8080/api/reports/1
    public ResponseEntity<Fornitore> updateFornitore(@RequestBody Fornitore fornitore) throws IOException{
    	Fornitore updatedFornitore = fornitoreService.updateFornitore(fornitore);
        return new ResponseEntity<>(updatedFornitore, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFornitore(@PathVariable("id") int fornitoreId){
    	fornitoreService.deleteFornitore(fornitoreId);
        return new ResponseEntity<>("Fornitore successfully deleted!", HttpStatus.OK);
    }
}
