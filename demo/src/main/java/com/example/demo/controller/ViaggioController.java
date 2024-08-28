package com.example.demo.controller;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Viaggio;
import com.example.demo.service.ViaggioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/viaggio")
public class ViaggioController {

    private ViaggioService viaggioService;

    @GetMapping("{id}")
    public ResponseEntity<Viaggio> getViaggioById(@PathVariable("id") int viaggioId){
    	Viaggio viaggio = viaggioService.getViaggioById(viaggioId);
        return new ResponseEntity<>(viaggio, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Viaggio>> getAllViaggi(){
        List<Viaggio> viaggi = viaggioService.getAllViaggi();
        Viaggio viaggio = viaggioService.getViaggioById(Integer.valueOf(5));
        viaggi.remove(viaggio);
        return new ResponseEntity<>(viaggi, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    public ResponseEntity<Viaggio> updateViaggio(@RequestBody Viaggio viaggio) throws IOException{
    	Viaggio updatedViaggio = viaggioService.updateViaggio(viaggio);
        return new ResponseEntity<>(updatedViaggio, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteViaggio(@PathVariable("id") int viaggioId){
    	viaggioService.deleteViaggio(viaggioId);
        return new ResponseEntity<>("Viaggio successfully deleted!", HttpStatus.OK);
    }
}
