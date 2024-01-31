package com.example.demo.controller;

import lombok.AllArgsConstructor;

import com.example.demo.entity.CategoriaDDT;
import com.example.demo.entity.Ruolo;
import com.example.demo.service.CategoriaDDTService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/categoriaDDT")
public class CategoriaDDTController {
    
    private CategoriaDDTService categoriaDDTService;

    @PostMapping
    public ResponseEntity<CategoriaDDT> createCategoriaDDT(@RequestBody CategoriaDDT categoria){
    	CategoriaDDT savedCategoria = categoriaDDTService.createCategoriaDDT(categoria);
        return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriaDDT> getCategoriaDDTById(@PathVariable("id") int categoriaId){
    	CategoriaDDT categoria = categoriaDDTService.getCategoriaDDTById(categoriaId);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDDT>> getAllCategorieDDT(){
        List<CategoriaDDT> categorie = categoriaDDTService.getAllCategorieDDT();
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    public ResponseEntity<CategoriaDDT> updateCategoria(@RequestBody CategoriaDDT categoriaDDT) throws IOException{
    	CategoriaDDT updatedCategoria = categoriaDDTService.updateCategoria(categoriaDDT);
        return new ResponseEntity<>(updatedCategoria, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable("id") int categoriaId){
    	categoriaDDTService.deleteCategoria(categoriaId);
        return new ResponseEntity<>("Categoria DDT successfully deleted!", HttpStatus.OK);
    }
}
