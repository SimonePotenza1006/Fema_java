package com.example.demo.controller;

import com.example.demo.entity.CategoriaPrezzoListino;
import com.example.demo.entity.Ruolo;
import com.example.demo.service.CategoriaPrezzoListinoService;

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
@RequestMapping(value = "/api/listino")
public class CategoriaPrezzoListinoController {
    
    private CategoriaPrezzoListinoService categoriaPrezzoListinoService;

    @PostMapping
    public ResponseEntity<CategoriaPrezzoListino> createCategoriaPrezzoListino(@RequestBody CategoriaPrezzoListino categoriaPrezzoListino){
    	CategoriaPrezzoListino savedCategoriaPrezzoListino = categoriaPrezzoListinoService.createCategoriaPrezzoListino(categoriaPrezzoListino);
        return new ResponseEntity<>(savedCategoriaPrezzoListino, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriaPrezzoListino> getCategoriaPrezzoListinoById(@PathVariable("id") int categoriaPrezzoListinoId){
    	CategoriaPrezzoListino categoriaPrezzoListino = categoriaPrezzoListinoService.getCategoriaPrezzoListinoById(categoriaPrezzoListinoId);
        return new ResponseEntity<>(categoriaPrezzoListino, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaPrezzoListino>> getAllCategoriePrezzoListini(){
        List<CategoriaPrezzoListino> categoriePrezzoListini = categoriaPrezzoListinoService.getAllCategoriePrezzoListini();
        return new ResponseEntity<>(categoriePrezzoListini, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    public ResponseEntity<CategoriaPrezzoListino> updateCategoriaPrezzoListino(@RequestBody CategoriaPrezzoListino categoriaPrezzoListino) throws IOException{
    	CategoriaPrezzoListino updatedCategoriaPrezzoListino = categoriaPrezzoListinoService.updateCategoriaPrezzoListino(categoriaPrezzoListino);
        return new ResponseEntity<>(updatedCategoriaPrezzoListino, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategoriaPrezzoListino(@PathVariable("id") int categoriaPrezzoListinoId){
    	categoriaPrezzoListinoService.deleteCategoriaPrezzoListino(categoriaPrezzoListinoId);
        return new ResponseEntity<>("Listino successfully deleted!", HttpStatus.OK);
    }
}
