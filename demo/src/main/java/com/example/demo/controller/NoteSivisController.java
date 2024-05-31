package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.NotaTecnico;
import com.example.demo.entity.NoteSivis;
import com.example.demo.service.impl.NoteSivisServiceImpl;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/noteSivis")
public class NoteSivisController {
    
    @Autowired
    private NoteSivisServiceImpl notaService;

    @PostMapping
    public ResponseEntity<NoteSivis> createNota(@RequestBody NoteSivis nota){
        NoteSivis savedNota = notaService.createNota(nota);
        return new ResponseEntity<>(savedNota, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<NoteSivis> getInterventoById(@PathVariable("id") int notaId) {
        int idvariable = notaId;
        NoteSivis nota = notaService.getNotaById(idvariable);
        if (nota == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nota, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<NoteSivis>> getAllNoteOrderByIdDesc(){
        List<NoteSivis> note = notaService.getAllNoteOrderByDesc();
        return new ResponseEntity<>(note, HttpStatus.OK);
    }
}
