package com.example.demo.controller;

import com.example.demo.entity.Agente;
import com.example.demo.entity.Azienda;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Preventivo;
import com.example.demo.entity.Utente;
import com.example.demo.service.AgenteService;
import com.example.demo.service.AziendaService;
import com.example.demo.service.PreventivoService;
import com.example.demo.service.UtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/preventivo")
public class PreventivoController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private AgenteService agenteService;

    @Autowired
    private AziendaService aziendaService;

    @Autowired
    private PreventivoService preventivoService;

    @PostMapping
    public ResponseEntity<Preventivo> createPreventivo(@RequestBody Preventivo preventivo){
        Preventivo savedPreventivo = preventivoService.createPreventivo(preventivo);
        return new ResponseEntity<>(savedPreventivo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Preventivo> getPreventivoById(@PathVariable("id") int preventivoId) {
        int idvariable = preventivoId;
        Preventivo preventivo = preventivoService.getPreventivoById(idvariable);
        if (preventivo == null) {
            System.out.println("Preventivo non trovato con ID: " + preventivoId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Preventivo non trovato con ID: " + preventivoId);
        return new ResponseEntity<>(preventivo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Preventivo>> getAllPreventivi(){
        List<Preventivo> preventivi = preventivoService.getAllPreventivi();
        return new ResponseEntity<>(preventivi, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<Preventivo>> getAllPreventiviOrderByDesc(){
        List<Preventivo> preventivo = preventivoService.getAllPreventiviOrderByDesc();
        return new ResponseEntity<>(preventivo, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<Preventivo>>> getPreventivoByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<Preventivo>> preventivi = preventivoService.getPreventivoByUtente(utente);
        return new ResponseEntity<>(preventivi, HttpStatus.OK);
    }

    @GetMapping("/agente/{id}")
    public ResponseEntity<List<Optional<Preventivo>>> getPreventivoByAgente(@PathVariable("id") int agenteId){
        Agente agente = agenteService.getAgenteById(agenteId);
        List<Optional<Preventivo>> preventivi = preventivoService.getPreventivoByAgente(agente);
        return new ResponseEntity<>(preventivi, HttpStatus.OK);
    }

    @GetMapping("/azienda/{id}")
    public ResponseEntity<List<Optional<Preventivo>>> getPreventivoByAzienda(@PathVariable("id") int aziendaId){
        Azienda azienda = aziendaService.getAziendaById(aziendaId);
        List<Optional<Preventivo>> preventivi = preventivoService.getPreventivoByAzienda(azienda);
        return new ResponseEntity<>(preventivi, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Preventivo> updatePreventivo(@RequestBody Preventivo preventivo) throws IOException{
        Preventivo updatedPreventivo = preventivoService.updatePreventivo(preventivo);
        return new ResponseEntity<>(updatedPreventivo, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteIntervento(@PathVariable("id") int preventivoId){
        preventivoService.deletePreventivo(preventivoId);
        return new ResponseEntity<>("Preventivo successfully deleted!", HttpStatus.OK);
    }
}