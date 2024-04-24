package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.service.ClienteService;
import com.example.demo.service.SopralluogoService;
import com.example.demo.service.TipologiaInterventoService;
import com.example.demo.service.UtenteService;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/sopralluogo")
public class SopralluogoController {
    
    @Autowired
    private SopralluogoService sopralluogoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UtenteService utenteService;

    @Autowired    
    private TipologiaInterventoService tipologiaInterventoService;

    @PostMapping
    public ResponseEntity<Sopralluogo> createSopralluogo(@RequestBody Sopralluogo sopralluogo){
        Sopralluogo savedSopralluogo = sopralluogoService.createSopralluogo(sopralluogo);
        return new ResponseEntity<>(savedSopralluogo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Sopralluogo> getSopralluogoById(@PathVariable("id") int sopralluogoId) {
        int idvariable = sopralluogoId;
        Sopralluogo sopralluogo = sopralluogoService.getSopralluogoById(idvariable);
        if (sopralluogo == null) {
            System.out.println("Sopralluogo non trovato con ID: " + sopralluogoId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Intervento non trovato con ID: " + sopralluogoId);
        return new ResponseEntity<>(sopralluogo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Sopralluogo>> getAllSopralluoghi(){
        List<Sopralluogo> sopralluoghi = sopralluogoService.getAllSopralluoghi();
        return new ResponseEntity<>(sopralluoghi, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<Sopralluogo>> getAllSopralluoghiOrderByDesc(){
        List<Sopralluogo> sopralluoghi = sopralluogoService.getAllSopralluoghiOrderByDesc();
        return new ResponseEntity<>(sopralluoghi, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<Sopralluogo>>> getSopralluoghiByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<Sopralluogo>> sopralluoghi = sopralluogoService.getSopralluogoByUtente(utente);
        return new ResponseEntity<>(sopralluoghi, HttpStatus.OK);
    }


    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Optional<Sopralluogo>>> getSopralluoghiByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<Optional<Sopralluogo>> sopralluoghi = sopralluogoService.getSopralluogoByCliente(cliente);
        return new ResponseEntity<>(sopralluoghi, HttpStatus.OK);
    }

    @GetMapping("/tipologia/{id}")
    public ResponseEntity<List<Optional<Sopralluogo>>> getSopralluogoByTipologia(@PathVariable("id") int tipologiaId){
        TipologiaIntervento tipologia = tipologiaInterventoService.getTipologiaInterventoById(tipologiaId);
        List<Optional<Sopralluogo>> sopralluoghi = sopralluogoService.getSopralluogoByTipologia(tipologia);
        return new ResponseEntity<>(sopralluoghi, HttpStatus.OK);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Sopralluogo> updateSopralluogo(@RequestBody Sopralluogo sopralluogo) throws IOException{
        Sopralluogo updatedSopralluogo = sopralluogoService.updateSopralluogo(sopralluogo);
        return new ResponseEntity<>(updatedSopralluogo, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSopralluogo(@PathVariable("id") int sopralluogoId){
        sopralluogoService.deleteSopralluogo(sopralluogoId);
        return new ResponseEntity<>("Sopralluogo successfully deleted!", HttpStatus.OK);
    }
}
