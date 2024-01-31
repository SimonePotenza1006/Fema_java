package com.example.demo.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.example.demo.entity.CategoriaInterventoSpecifico;
import com.example.demo.entity.Spesa;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.entity.Viaggio;
import com.example.demo.service.CategoriaInterventoSpecificoService;
import com.example.demo.service.TipologiaInterventoService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/categorieIntervento")
public class CategoriaInterventoSpecificoController {
    
    private CategoriaInterventoSpecificoService categoriaService;
    private TipologiaInterventoService tipologiaInterventoService;

    @PostMapping
    public ResponseEntity<CategoriaInterventoSpecifico> createCategoriaInterventoSpecifico(@RequestBody CategoriaInterventoSpecifico categoria){
    	CategoriaInterventoSpecifico savedCategoria = categoriaService.createCategoriaInterventoSpecifico(categoria);
        return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriaInterventoSpecifico> getCategoriaInterventoSpecificoById(@PathVariable("id") int categoriaId){
    	CategoriaInterventoSpecifico categoria = categoriaService.getCategoriaInterventoSpecificoById(categoriaId);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaInterventoSpecifico>> getAllCategorieInterventoSpecifiche(){
        List<CategoriaInterventoSpecifico> categorie = categoriaService.getAllCategorieInterventoSpecifiche();
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }

    @GetMapping("/tipologia/{id}")
    public ResponseEntity<List<Optional<CategoriaInterventoSpecifico>>> getCategoriaSpecificaByTipologia(@PathVariable("id") int tipologiaId){
    	TipologiaIntervento tipologia = tipologiaInterventoService.getTipologiaInterventoById(tipologiaId);
        List<Optional<CategoriaInterventoSpecifico>> categorie = categoriaService.getCategoriaSpecificaByTipologia(tipologia);
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    public ResponseEntity<CategoriaInterventoSpecifico> updateCategoriaInterventoSpecifico(@RequestBody CategoriaInterventoSpecifico categoria) throws IOException{
    	CategoriaInterventoSpecifico updatedCategoria = categoriaService.updateCategoriaInterventoSpecifico(categoria);
        return new ResponseEntity<>(updatedCategoria, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategoriaInterventoSpecifico(@PathVariable("id") int categoriaId){
    	categoriaService.deleteCategoriaInterventoSpecifico(categoriaId);
        return new ResponseEntity<>("Categoria specifica successfully deleted!", HttpStatus.OK);
    }
}
