package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.NoleggioDevirent;
import com.example.demo.service.NoleggioDevirentService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/noleggiodevirent")
public class NoleggioDevirentController {
    
    @Autowired
    private NoleggioDevirentService noleggioService;

    @PostMapping
    public ResponseEntity<NoleggioDevirent> createNoleggio(@RequestBody NoleggioDevirent noleggio){
        NoleggioDevirent noleggioDevirent = noleggioService.createNoleggio(noleggio);
        return new ResponseEntity<>(noleggioDevirent, HttpStatus.CREATED);
    }

    @GetMapping("/getfile/{filename}")
    public ResponseEntity<NoleggioDevirent> getNoleggioByName(@PathVariable("filename") String filename){
        NoleggioDevirent noleggioDevirent = noleggioService.getNoleggioByFilename(filename);
        return new ResponseEntity<>(noleggioDevirent, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNoleggio(@PathVariable("id") int noleggioId){
        noleggioService.deleteNoleggio(noleggioId);
        return new ResponseEntity<>("Noleggio successfully deleted!", HttpStatus.OK);
    }
    
    
}
