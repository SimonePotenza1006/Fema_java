package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.CategoriaDDT;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Ddt;
import com.example.demo.entity.Destinazione;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Utente;
import com.example.demo.service.CategoriaDDTService;
import com.example.demo.service.ClienteService;
import com.example.demo.service.DdtService;
import com.example.demo.service.DestinazioneService;
import com.example.demo.service.InterventoService;
import com.example.demo.service.UtenteService;
import java.io.IOException;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/ddt")
public class DdtController {
    
    @Autowired
    private DdtService ddtService;

    @Autowired
    private ClienteService clienteService;

    @Autowired 
    private DestinazioneService destinazioneService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private InterventoService interventoService;

    @Autowired
    private CategoriaDDTService categoriaDDTService;

    @PostMapping
    public ResponseEntity<Ddt> createDdt(@RequestBody Ddt ddt){
        System.out.println("Prova createDDT");
        Ddt savedDdt = ddtService.createDdt(ddt);
        return new ResponseEntity<>(savedDdt, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ddt> getDdtById(@PathVariable("id") int ddtId){
        Ddt ddt = ddtService.getDdtById(ddtId);
        return new ResponseEntity<>(ddt, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ddt>> getAllDdt(){
        List<Ddt> ddt = ddtService.getAllDdt();
        return new ResponseEntity<>(ddt, HttpStatus.OK);
    }

    @GetMapping("/categoriaDdt/{id}")
    public ResponseEntity<List<Optional<Ddt>>> getDdtByCategoria(@PathVariable("id") int categoriaDdtId){
        CategoriaDDT categoria = categoriaDDTService.getCategoriaDDTById(categoriaDdtId);
        List<Optional<Ddt>> ddt = ddtService.getDdtByCategoriaDdt(categoria);
        return new ResponseEntity<>(ddt, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Optional<Ddt>>> getDdtByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<Optional<Ddt>> ddt = ddtService.getDdtByCliente(cliente);
        return new ResponseEntity<>(ddt, HttpStatus.OK);
    }

    @GetMapping("/destinazione/{id}")
    public ResponseEntity<List<Optional<Ddt>>> getDdtByDestinazione(@PathVariable("id") int destinazioneId){
        Destinazione destinazione = destinazioneService.getDestinazioneById(destinazioneId);
        List<Optional<Ddt>> ddt = ddtService.getDdtByDestinazione(destinazione);
        return new ResponseEntity<>(ddt, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<Ddt>>> getDdtByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<Ddt>> ddt = ddtService.getDdtByUtente(utente);
        return new ResponseEntity<>(ddt, HttpStatus.OK);
    }

    @GetMapping("/intervento/{id}")
    public ResponseEntity<Optional<Ddt>> getDdtByIntervento(@PathVariable("id") int interventoId){
        Intervento intervento = interventoService.getInterventoById(interventoId);
        Optional<Ddt> ddt = ddtService.getDdtByIntervento(intervento);
        return new ResponseEntity<>(ddt, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Ddt> updateDdt(@RequestBody Ddt ddt) throws IOException{
        Ddt updatedDdt = ddtService.updateDdt(ddt);
        return new ResponseEntity<>(updatedDdt, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDdt(@PathVariable("id") int ddtId){
        ddtService.deleteDdt(ddtId);
        return new ResponseEntity<>("Ddt successfully deleted", HttpStatus.OK);
    }
}
