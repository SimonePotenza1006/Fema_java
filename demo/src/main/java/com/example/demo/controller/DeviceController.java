package com.example.demo.controller;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Cantiere;
import com.example.demo.entity.Device;
import com.example.demo.entity.Licenza;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente;
import com.example.demo.service.AziendaService;
import com.example.demo.service.DeviceService;
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
@RequestMapping(value = "/api/device")//, consumes = { "multipart/form-data" })
public class DeviceController {

    private DeviceService ruoloService;
    
    //@Autowired
    //private FileStorageService storageService;

    // build create Report REST API
    @PostMapping
    public ResponseEntity<Device> createRuolo(@RequestBody Device ruolo){
    	//Cantiere savedCantiere = cantiereService.createCantiere(cantiere);
    	Device savedRuolo = ruoloService.createRuolo(ruolo);
    	
    	/*try {

		    Path path = Paths.get("C:\\AppSivis\\Aziende\\"+savedRuolo.getDescrizione()+"\\Timbro");

		    //java.nio.file.Files;
		    Files.createDirectories(path);

		    System.out.println("Directory is created! a "+path.toString());

		  } catch (IOException e) {

		    System.err.println("Failed to create directory!" + e.getMessage());

		  }*/
    	
        return new ResponseEntity<>(savedRuolo, HttpStatus.CREATED);
    }

    // build get report by id REST API
    // http://localhost:8080/api/reports/1
    @GetMapping("{id}")
    public ResponseEntity<Device> getRuoloById(@PathVariable("id") Long ruoloId){
    	Device ruolo = ruoloService.getRuoloById(ruoloId);
        return new ResponseEntity<>(ruolo, HttpStatus.OK);
    }

    // Build Get All Reports REST API
    // http://localhost:8080/api/reports
    @GetMapping
    public ResponseEntity<List<Device>> getAllRuoli(){
        List<Device> ruoli = ruoloService.getAllRuoli();
        return new ResponseEntity<>(ruoli, HttpStatus.OK);
    }

    // Build Update Report REST API
    @PutMapping//("{id}")
    // http://localhost:8080/api/reports/1
    public ResponseEntity<Device> updateRuolo(//@PathVariable("id") Long utenteId//, @RequestParam("file") MultipartFile file
    		@RequestBody Device ruolo
    		) throws IOException{
    	//String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //long size = multipartFile.getSize();
         
        //String filecode = FileUploadUtil.saveFile(fileName, file);
    	//report.setId(reportId);
    	//Utente utente = utenteService.getUtenteById(utenteId);
    	//Utente updatedUtente = utenteService.updateUtente(utente);
    	Device updatedRuolo = ruoloService.updateRuolo(ruolo);
        return new ResponseEntity<>(updatedRuolo, HttpStatus.OK);
    }

    // Build Delete Report REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRuolo(@PathVariable("id") Long ruoloId){
    	ruoloService.deleteRuolo(ruoloId);
        return new ResponseEntity<>("Ruolo successfully deleted!", HttpStatus.OK);
    }
}
