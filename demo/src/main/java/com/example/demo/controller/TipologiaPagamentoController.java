package com.example.demo.controller;

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
import com.example.demo.entity.TipologiaPagamento;
import com.example.demo.service.TipologiaPagamentoService;
import java.util.List;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/tipologiapagamento")
public class TipologiaPagamentoController {
    
    private TipologiaPagamentoService tipologiaPagamentoService;

    @PostMapping
    public ResponseEntity<TipologiaPagamento> createTipologiaPagamento(@RequestBody TipologiaPagamento tipologiaPagamento){
        TipologiaPagamento savedTipologiaPagamento = tipologiaPagamentoService.createTipologiaPagamento(tipologiaPagamento);
        return new ResponseEntity<>(savedTipologiaPagamento, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TipologiaPagamento> getTipologiaPagamentoById(@PathVariable("id") int tipologiaPagamentoId){
        TipologiaPagamento tipologiaPagamento = tipologiaPagamentoService.getTipologiaPagamentoById(tipologiaPagamentoId);
        return new ResponseEntity<>(tipologiaPagamento, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TipologiaPagamento>> getAllTipologiePagamento(){
        List<TipologiaPagamento> tipologiePagamento = tipologiaPagamentoService.getAllTipologiePagamento();
        return new ResponseEntity<>(tipologiePagamento, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TipologiaPagamento> updateTipologiaPagamento(@RequestBody TipologiaPagamento tipologiaPagamento) throws IOException{
        TipologiaPagamento updatedTipologiaPagamento = tipologiaPagamentoService.updateTipologiaPagamento(tipologiaPagamento);
        return new ResponseEntity<>(updatedTipologiaPagamento, HttpStatus.OK);
    }

    @DeleteMapping({"id"})
    public ResponseEntity<String> deleteTipologiaPagamento(@PathVariable("id") int tipologiaPagamentoId){
        tipologiaPagamentoService.deleteTipologiaPagamento(tipologiaPagamentoId);
        return new ResponseEntity<>("Tipologia pagamento succesfully deleted!!", HttpStatus.OK);
    }
}
