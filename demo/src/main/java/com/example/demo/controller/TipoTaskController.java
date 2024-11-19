package com.example.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import com.example.demo.entity.TipoTask;

import com.example.demo.service.TipoTaskService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/tipoTask")
public class TipoTaskController {
    
    TipoTaskService tipoService;

    @PostMapping
    public ResponseEntity<TipoTask> createTipo(@RequestBody TipoTask tipo){
        TipoTask savedTipo = tipoService.create(tipo);
        return new ResponseEntity<>(savedTipo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<TipoTask>> getTipoById(@PathVariable("id") int tipoId){
        Optional<TipoTask> optionalTipo = tipoService.getTipoById(tipoId);
        return new ResponseEntity<>(optionalTipo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TipoTask>> getAllTipi(){
        List<TipoTask> tipi = tipoService.getAllTipi();
        return new ResponseEntity<>(tipi, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTipo(@PathVariable ("id") int tipoId){
        tipoService.deleteTipo(tipoId);
        return new ResponseEntity<>("Tipologia task successfully deleted!", HttpStatus.OK);
    }
}
