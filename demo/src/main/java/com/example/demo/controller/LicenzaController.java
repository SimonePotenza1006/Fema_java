package com.example.demo.controller;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Licenza;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente;
import com.example.demo.service.AziendaService;
import com.example.demo.service.LicenzaService;
import com.example.demo.service.RuoloService;
import com.example.demo.service.UtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/licenza")//, consumes = { "multipart/form-data" })
public class LicenzaController {

    private LicenzaService ruoloService;
    
    //@Autowired
    //private FileStorageService storageService;

    // build create Report REST API
    @PostMapping
    public ResponseEntity<Licenza> createRuolo(@RequestBody String ruolo){
    	System.out.println(ruolo+" licenza utilizzata");
    	Licenza savedRuolo = ruoloService.getRuoloByDescrizione(ruolo);
    	savedRuolo.setUtilizzato(true);
    	//Licenza savedRuolo = ruoloService.createRuolo(ruolo);
    	Licenza savedRuoloUt = ruoloService.createRuolo(savedRuolo);
    	
    	
        return new ResponseEntity<>(savedRuoloUt, HttpStatus.CREATED);
    }

    // build get report by id REST API
    // http://localhost:8080/api/reports/1
    @GetMapping("{id}")
    public ResponseEntity<Licenza> getRuoloById(@PathVariable("id") Long ruoloId){
    	Licenza ruolo = ruoloService.getRuoloById(ruoloId);
        return new ResponseEntity<>(ruolo, HttpStatus.OK);
    }

    // Build Get All Reports REST API
    // http://localhost:8080/api/reports
    @GetMapping
    public ResponseEntity<List<Licenza>> getAllRuoli(){
        List<Licenza> ruoli = ruoloService.getAllRuoli();
        return new ResponseEntity<>(ruoli, HttpStatus.OK);
    }

    // Build Update Report REST API
    @PutMapping//("{id}")
    // http://localhost:8080/api/reports/1
    public ResponseEntity<Licenza> updateRuolo(//@PathVariable("id") Long utenteId//, @RequestParam("file") MultipartFile file
    		@RequestBody Licenza ruolo
    		) throws IOException{
    	//String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //long size = multipartFile.getSize();
         
        //String filecode = FileUploadUtil.saveFile(fileName, file);
    	//report.setId(reportId);
    	//Utente utente = utenteService.getUtenteById(utenteId);
    	//Utente updatedUtente = utenteService.updateUtente(utente);
    	Licenza updatedRuolo = ruoloService.updateRuolo(ruolo);
        return new ResponseEntity<>(updatedRuolo, HttpStatus.OK);
    }

    // Build Delete Report REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRuolo(@PathVariable("id") Long ruoloId){
    	ruoloService.deleteRuolo(ruoloId);
        return new ResponseEntity<>("Ruolo successfully deleted!", HttpStatus.OK);
    }
}
