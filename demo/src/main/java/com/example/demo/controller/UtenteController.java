package com.example.demo.controller;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Utente;
import com.example.demo.service.UtenteService;
import com.example.demo.entity.ApiResponse;

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
@RequestMapping(value = "/api/utente")
public class UtenteController {
    
    private UtenteService utenteService;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody Utente loginDto){
        System.out.println("PROVA Login!");
        return utenteService.login(loginDto);
    }

    @PostMapping("/ulogin")
    public Utente ulogin(@RequestBody Utente loginDto){
        System.out.println("PROVA ulogin!");
        return utenteService.ulogin(loginDto);
    }

    @PostMapping
    public ResponseEntity<Utente> createUtente(@RequestBody Utente utente){
        Utente savedUtente = utenteService.createUtente(utente);
        return new ResponseEntity<>(savedUtente, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Utente> getUtenteById(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        System.out.println("hlhh");
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Utente> getUtenteByEmail(@PathVariable("email") String utenteEmail){
    	Utente utente = utenteService.getUtenteByEmail(utenteEmail);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    @GetMapping("/ruolo/tecnico")
    public ResponseEntity<List<Utente>> getUtentiTecnici(){
    	List<Utente> utenti = utenteService.getUtentiTecnici();
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Utente>> getAllUtenti(){
        List<Utente> utenti = utenteService.getAllUtenti();
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    public ResponseEntity<Utente> updateUtente(//@PathVariable("id") Long utenteId,//, @RequestParam("file") MultipartFile file
    		@RequestBody Utente utente
    		) throws IOException{
    	//String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //long size = multipartFile.getSize();
         
        //String filecode = FileUploadUtil.saveFile(fileName, file);
    	//report.setId(reportId);
    	//Utente utenteg = utenteService.getUtenteById(utenteId);
    	Utente updatedUtente = utenteService.updateUtente(utente);
    	//Utente utente = utenteService.updateUtente(utente);
        return new ResponseEntity<>(updatedUtente, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUtente(@PathVariable("id") int utenteId){
    	utenteService.deleteUtente(utenteId);
        return new ResponseEntity<>("Utente successfully deleted!", HttpStatus.OK);
    }
}
