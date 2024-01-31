package com.example.demo.controller;

import com.example.demo.entity.CategoriaProdotto;
import com.example.demo.entity.Ruolo;
import com.example.demo.service.CategoriaProdottoService;

import lombok.AllArgsConstructor;

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
@RequestMapping(value = "/api/categoriaProdotto")
public class CategoriaProdottoController {
    
    private CategoriaProdottoService categoriaProdottoService;

    @PostMapping
    public ResponseEntity<CategoriaProdotto> createCategoriaProdotto(@RequestBody CategoriaProdotto categoriaProdotto){
    	CategoriaProdotto savedCategoriaProdotto = categoriaProdottoService.createCategoriaProdotto(categoriaProdotto);
        return new ResponseEntity<>(savedCategoriaProdotto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriaProdotto> getCategoriaProdottoById(@PathVariable("id") int categoriaProdottoId){
    	CategoriaProdotto categoriaProdotto = categoriaProdottoService.getCategoriaProdottoById(categoriaProdottoId);
        return new ResponseEntity<>(categoriaProdotto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaProdotto>> getAllCategorieProdotti(){
        List<CategoriaProdotto> categorieProdotti = categoriaProdottoService.getAllCategorieProdotti();
        return new ResponseEntity<>(categorieProdotti, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    public ResponseEntity<CategoriaProdotto> updatedCategoriaProdotto(@RequestBody CategoriaProdotto categoriaProdotto) throws IOException{
    	CategoriaProdotto updatedCategorieProdotti = categoriaProdottoService.updateCategoriaProdotto(categoriaProdotto);
        return new ResponseEntity<>(updatedCategorieProdotti, HttpStatus.OK);
    }

    // Build Delete Report REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategoriaProdotto(@PathVariable("id") int categoriaProdottoId){
    	categoriaProdottoService.deleteCategoriaProdotto(categoriaProdottoId);
        return new ResponseEntity<>("Categoria prodotto successfully deleted!", HttpStatus.OK);
    }
}
