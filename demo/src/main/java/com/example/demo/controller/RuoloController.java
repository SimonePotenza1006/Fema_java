package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Ruolo;
import com.example.demo.service.RuoloService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/ruolo")
public class RuoloController {
    
    private RuoloService ruoloService;

    @PostMapping
    public ResponseEntity<Ruolo> createRuolo(@RequestBody Ruolo ruolo){
    	Ruolo savedRuolo = ruoloService.createRuolo(ruolo);
        return new ResponseEntity<>(savedRuolo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ruolo> getRuoloById(@PathVariable("id") int ruoloId){
    	Ruolo ruolo = ruoloService.getRuoloById(ruoloId);
        return new ResponseEntity<>(ruolo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ruolo>> getAllRuoli(){
        List<Ruolo> ruoli = ruoloService.getAllRuoli();
        return new ResponseEntity<>(ruoli, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    // http://localhost:8080/api/reports/1
    public ResponseEntity<Ruolo> updateRuolo(//@PathVariable("id") Long utenteId//, @RequestParam("file") MultipartFile file
    		@RequestBody Ruolo ruolo
    		) throws IOException{
    	//String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //long size = multipartFile.getSize();
         
        //String filecode = FileUploadUtil.saveFile(fileName, file);
    	//report.setId(reportId);
    	//Utente utente = utenteService.getUtenteById(utenteId);
    	//Utente updatedUtente = utenteService.updateUtente(utente);
    	Ruolo updatedRuolo = ruoloService.updateRuolo(ruolo);
        return new ResponseEntity<>(updatedRuolo, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRuolo(@PathVariable("id") int ruoloId){
    	ruoloService.deleteRuolo(ruoloId);
        return new ResponseEntity<>("Ruolo successfully deleted!", HttpStatus.OK);
    }
}
