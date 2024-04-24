package com.example.demo.controller;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import com.example.demo.service.UtenteService;
import com.example.demo.service.CommissioneService;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Commissione;
import com.example.demo.entity.Task;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/commissione")
public class CommissioneController {
    
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private CommissioneService commissioneService;

    @PostMapping
    public ResponseEntity<Commissione> createCommissione(@RequestBody Commissione commissione){
        Commissione savedCommissione = commissioneService.createCommissione(commissione);
        return new ResponseEntity<>(savedCommissione, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Commissione> getCommissioneById(@PathVariable("id") int commissioneId) {
        int idvariable = commissioneId;
        Commissione commissione = commissioneService.getCommissioneById(idvariable);
        if (commissione == null) {
            System.out.println("Commissione non trovato con ID: " + commissioneId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commissione, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Commissione>> getAllCommissioni(){
        List<Commissione> commissioni = commissioneService.getAllCommissioni();
        return new ResponseEntity<>(commissioni, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<Commissione>> getAllCommissioniOrderByDesc(){
        List<Commissione> commissioni = commissioneService.getAllCommissioniOrderByDesc();
        return new ResponseEntity<>(commissioni, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<Commissione>>> getCommissioneByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<Commissione>> commissioni = commissioneService.getCommissioneByUtente(utente);
        return new ResponseEntity<>(commissioni, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Commissione> updateCommissione(@RequestBody Commissione commissione) throws IOException{
        Commissione updatedCommissione = commissioneService.updateCommissione(commissione);
        return new ResponseEntity<>(updatedCommissione, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCommissione(@PathVariable("id") int commissioneId){
        commissioneService.deleteCommissione(commissioneId);
        return new ResponseEntity<>("Commissione successfully deleted!", HttpStatus.OK);
    }
}
