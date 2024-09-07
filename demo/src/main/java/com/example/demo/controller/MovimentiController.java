package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.Movimenti;
import com.example.demo.entity.TipologiaMovimento;
import com.example.demo.repository.TipologiaMovimentoRepository;
import com.example.demo.service.InterventoService;
import com.example.demo.service.MovimentiService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movimenti")
public class MovimentiController {

    @Autowired
    private TipologiaMovimentoRepository tipologiaRepository;
    
    @Autowired
    private MovimentiService movimentiService;

    @Autowired 
    private InterventoService interventoService;

    @GetMapping
    public ResponseEntity<List<Movimenti>> getAllMovimenti() {
        List<Movimenti> movimentiList = movimentiService.getAllMovimenti();
        return new ResponseEntity<>(movimentiList, HttpStatus.OK);
    }

    // Endpoint per recuperare un movimento per ID
    @GetMapping("/{id}")
    public ResponseEntity<Movimenti> getMovimentiById(@PathVariable("id") int id) {
        Optional<Movimenti> movimenti = movimentiService.getMovimentiById(id);
        if (movimenti.isPresent()) {
            return new ResponseEntity<>(movimenti.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("ordered")
    public ResponseEntity<List<Movimenti>> getAllMovimentiOrderByDesc(){
        List<Movimenti> movimenti = movimentiService.getAllMovimentiOrderByDesc();
        return new ResponseEntity<>(movimenti, HttpStatus.OK);
    }

    @GetMapping("/intervento/{id}")
    public ResponseEntity<List<Optional<Movimenti>>> getMovimentiByIntervento(@PathVariable("id") int interventoId){
        Intervento intervento = interventoService.getInterventoById(interventoId);
        List<Optional<Movimenti>> movimenti = movimentiService.getMovimentiByIntervento(intervento);
        return new ResponseEntity<>(movimenti, HttpStatus.OK);
    }

    @GetMapping("/tipologia/{id}")
    public ResponseEntity<List<Movimenti>> getMovimentiByTipologia(@PathVariable("id") int tipologiaId){
        TipologiaMovimento tipoloigia = tipologiaRepository.findById(tipologiaId);
        List<Movimenti> movimenti = movimentiService.getAllByTipologiaOrdered(tipoloigia);
        return new ResponseEntity<>(movimenti, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movimenti> saveMovimenti(@RequestBody Movimenti movimento) {
        System.out.println("PROVAAAAAAAAAAAAAAAAAAAAAAAAAAAAA ");
        Movimenti savedMovimento = movimentiService.saveMovimenti(movimento);
        return new ResponseEntity<>(savedMovimento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimentiById(@PathVariable("id") int id) {
        movimentiService.deleteMovimentiById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
