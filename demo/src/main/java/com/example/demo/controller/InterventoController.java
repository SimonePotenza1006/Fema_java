package com.example.demo.controller;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.GruppoInterventi;
import com.example.demo.service.TipologiaInterventoService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.impl.InterventoServiceImpl;
import com.example.demo.service.ClienteService;
import com.example.demo.service.GruppoInterventiService;
import com.example.demo.service.MerceInRiparazioneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/intervento")
public class InterventoController {

    @Autowired
    private InterventoServiceImpl interventoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired 
    private GruppoInterventiService gruppoService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private MerceInRiparazioneService merceService;

    @Autowired
    private TipologiaInterventoService tipologiaInterventoService;

    @PostMapping
    public ResponseEntity<Intervento> createIntervento(@RequestBody Intervento intervento){
        Intervento savedIntervento = interventoService.createIntervento(intervento);
        return new ResponseEntity<>(savedIntervento, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Intervento> getInterventoById(@PathVariable("id") int interventoId) {
        int idvariable = interventoId;
        Intervento intervento = interventoService.getInterventoById(idvariable);
        if (intervento == null) {
            System.out.println("Intervento non trovato con ID: " + interventoId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Intervento non trovato con ID: " + interventoId);
        return new ResponseEntity<>(intervento, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Intervento>> getAllInterventi(){
        List<Intervento> interventi = interventoService.getAllInterventi();
        System.out.println("Get all interventi");
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("withMerce")
    public ResponseEntity<List<Intervento>> getAllInterventiWithMerce(){
        List<Intervento> interventi = interventoService.getAllInterventiWithMerce();
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }



    @GetMapping("ordered")
    public ResponseEntity<List<Intervento>> getAllInterventiOrderByDesc(){
        List<Intervento> interventi = interventoService.getAllInterventiOrderdByDesc();
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("orderedByGroup")
    public ResponseEntity<List<Intervento>> getAllInterventiOrderByGruppo(){
        List<Intervento> interventi = interventoService.getInterventiOrderedByGruppo();
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Optional<Intervento>>> getInterventiByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<Optional<Intervento>> interventi = interventoService.getInterventoByCliente(cliente);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("withMerce/{id}")
    public ResponseEntity<List<Intervento>> getInterventiWithMerceByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Intervento> interventi = interventoService.getAllInterventiWithMerceNonConclusiByUtente(utente);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("/categoriaIntervento/{id}")
    public ResponseEntity<List<Optional<Intervento>>> getInterventoByTipologia(@PathVariable("id") int tipologiaId){
        TipologiaIntervento tipologia = tipologiaInterventoService.getTipologiaInterventoById(tipologiaId);
        List<Optional<Intervento>> interventi = interventoService.getInterventoByTipologia(tipologia);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<Intervento>>> getInterventoByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<Intervento>> interventi = interventoService.getInterventoByUtente(utente);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("/gruppo/{id}")
    public ResponseEntity<List<Optional<Intervento>>> getInterventoByGruppo(@PathVariable("id") int gruppoId){
        GruppoInterventi gruppo = gruppoService.getGruppoById(gruppoId);
        List<Optional<Intervento>> interventi = interventoService.getInterventiByGruppo(gruppo);
        return new ResponseEntity<>(interventi, HttpStatus.OK); 
    }
    
    @GetMapping("/merce/{id}")
    public ResponseEntity<List<Intervento>> getInterventoByMerce(@PathVariable("id") int merceId){
        MerceInRiparazione merce = merceService.getMerceById(merceId);
        List<Intervento> interventi = interventoService.getInterventiByMerce(merce);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<Intervento> updateIntervento(@RequestBody Intervento intervento) throws IOException{
        Intervento updatedIntervento = interventoService.updateIntervento(intervento);
        return new ResponseEntity<>(updatedIntervento, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteIntervento(@PathVariable("id") int interventoId){
        interventoService.deleteIntervento(interventoId);
        return new ResponseEntity<>("Intervento successfully deleted!", HttpStatus.OK);
    }
}