package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.entity.Attrezzatura;
import com.example.demo.service.AttrezzaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;  


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/attrezzatura")
public class AttrezzaturaController {
    
    private AttrezzaturaService attrezzaturaService;

    @PostMapping
    public ResponseEntity<Attrezzatura> createAttrezzatura(@RequestBody Attrezzatura attrezzatura){
    	Attrezzatura savedAttrezzatura = attrezzaturaService.createAttrezzatura(attrezzatura);
        return new ResponseEntity<>(savedAttrezzatura, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Attrezzatura> getAttrezzaturaById(@PathVariable("id") int attrezzaturaId){
    	Attrezzatura attrezzatura = attrezzaturaService.getAttrezzaturaById(attrezzaturaId);
        return new ResponseEntity<>(attrezzatura, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Attrezzatura>> getAllAttrezzature(){
        List<Attrezzatura> attrezzature = attrezzaturaService.getAllAttrezzature();
        return new ResponseEntity<>(attrezzature, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    public ResponseEntity<Attrezzatura> updateAttrezzatura(@RequestBody Attrezzatura attrezzatura) throws IOException{
    	Attrezzatura updatedAttrezzatura = attrezzaturaService.updateAttrezzatura(attrezzatura);
        return new ResponseEntity<>(updatedAttrezzatura, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAttrezzatura(@PathVariable("id") int attrezzaturaId){
    	attrezzaturaService.deleteAttrezzatura(attrezzaturaId);
        return new ResponseEntity<>("Attrezzatura successfully deleted!", HttpStatus.OK);
    }
}
