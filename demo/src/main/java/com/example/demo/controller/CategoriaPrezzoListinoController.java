package com.example.demo.controller;

import com.example.demo.entity.CategoriaInterventoSpecifico;
import com.example.demo.entity.CategoriaPrezzoListino;
import com.example.demo.service.CategoriaInterventoSpecificoService;
import com.example.demo.service.CategoriaPrezzoListinoService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/listino")
public class CategoriaPrezzoListinoController {
    
    @Autowired
    private CategoriaPrezzoListinoService categoriaPrezzoListinoService;

    @Autowired
    private CategoriaInterventoSpecificoService categoriaInterventoSpecificoService;

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

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<CategoriaPrezzoListino>> getListinoSpecificaByCategoria(@PathVariable("id") int categoriaId) {
    CategoriaInterventoSpecifico categoria = categoriaInterventoSpecificoService.getCategoriaInterventoSpecificoById(categoriaId);
    List<CategoriaPrezzoListino> listini = categoriaPrezzoListinoService.getPrezzoListinoByCategoria(categoria)
            .stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    return new ResponseEntity<>(listini, HttpStatus.OK);
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
