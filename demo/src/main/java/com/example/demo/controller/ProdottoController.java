package com.example.demo.controller;

import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Spesa;
import com.example.demo.entity.Viaggio;
import com.example.demo.entity.Fornitore;
import com.example.demo.entity.CategoriaProdotto;
import com.example.demo.service.ProdottoService;
import com.example.demo.service.FornitoreService;
import com.example.demo.service.CategoriaProdottoService;



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
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/prodotto")
public class ProdottoController {
    
    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private FornitoreService fornitoreService;

    @Autowired
    private CategoriaProdottoService categoriaProdottoService;

    @PostMapping
    public ResponseEntity<Prodotto> createProdotto(@RequestBody Prodotto prodotto){
    	Prodotto savedProdotto = prodottoService.createProdotto(prodotto);
        return new ResponseEntity<>(savedProdotto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Prodotto> getProdottoById(@PathVariable("id") int prodottoId){
    	Prodotto prodotto = prodottoService.getProdottoById(prodottoId);
        return new ResponseEntity<>(prodotto, HttpStatus.OK);
    }

    @GetMapping("/DDT/{codice_danea}/{lotto_seriale}")
    public ResponseEntity<Optional<Prodotto>> getProdottoForDDT(@PathVariable("codice_danea") String codice_danea, @PathVariable("lotto_seriale") String lotto_seriale){
        Optional<Prodotto> prodotto = prodottoService.getProdottoForDDT(codice_danea, lotto_seriale);
        System.out.println(lotto_seriale);
        System.out.println(codice_danea);
        return new ResponseEntity<>(prodotto, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Prodotto>> getAllProdotti(){
        List<Prodotto> prodotti = prodottoService.getAllProdotti();
        return new ResponseEntity<>(prodotti, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Prodotto> updateProdotto(@RequestBody Prodotto prodotto) throws IOException{
    	Prodotto updatedProdotto = prodottoService.updateProdotto(prodotto);
        return new ResponseEntity<>(updatedProdotto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProdotto(@PathVariable("id") int prodottoId){
    	prodottoService.deleteProdotto(prodottoId);
        return new ResponseEntity<>("Prodotto successfully deleted!", HttpStatus.OK);
    }
}
