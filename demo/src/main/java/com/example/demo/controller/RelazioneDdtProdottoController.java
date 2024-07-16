package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Ddt;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.RelazioneDdtProdotto;
import com.example.demo.service.DdtService;
import com.example.demo.service.ProdottoService;
import com.example.demo.service.impl.RelazioneDdtProdottoServiceImpl;
import com.fasterxml.jackson.core.StreamReadConstraints;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Configuration
@RestController
@RequestMapping(value = "/api/relazioneDDTProdotto")
public class RelazioneDdtProdottoController {
    
    @Bean
    Jackson2ObjectMapperBuilderCustomizer customStreamReadConstraints() {
	return (builder) -> builder.postConfigurer((objectMapper) -> objectMapper.getFactory()
		.setStreamReadConstraints(StreamReadConstraints.builder().maxNestingDepth(2000).build()));
    }

    @Autowired
    private RelazioneDdtProdottoServiceImpl relazioneService;

    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private DdtService ddtService;

    @PostMapping
    public ResponseEntity<RelazioneDdtProdotto> createRelazioneDdtProdotto(@RequestBody RelazioneDdtProdotto relazioneDdtProdotto){
        RelazioneDdtProdotto relazione = relazioneService.createRelazioneDdtProdotto(relazioneDdtProdotto);
        return new ResponseEntity<>(relazione, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RelazioneDdtProdotto> getRelazioneDdtProdottoById(@PathVariable("id") int relazioneId){
        RelazioneDdtProdotto relazione = relazioneService.getRelazioneDdtProdottoById(relazioneId);
        return new ResponseEntity<>(relazione, HttpStatus.OK);
    }

    @GetMapping("scaricato")
    public ResponseEntity<List<RelazioneDdtProdotto>> findAllNonScaricati(){
        List<RelazioneDdtProdotto> relazioni = relazioneService.findByStatus(false);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RelazioneDdtProdotto>> getAllRelazioni(){
        List<RelazioneDdtProdotto> relazioni = relazioneService.getAllRelazioni();
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/prodotto/{id}")
    public ResponseEntity<List<Optional<RelazioneDdtProdotto>>> getRelazioneByProdotto(@PathVariable("id") int prodottoId){
        Prodotto prodotto = prodottoService.getProdottoById(prodottoId);
        List<Optional<RelazioneDdtProdotto>> relazioni = relazioneService.getRelazioniByProdotto(prodotto);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @GetMapping("/ddt/{id}")
    public ResponseEntity<List<Optional<RelazioneDdtProdotto>>> getRelazioneByDdt(@PathVariable("id") int ddtId){
        Ddt ddt = ddtService.getDdtById(ddtId);
        List<Optional<RelazioneDdtProdotto>> relazioni = relazioneService.getRelazioniByDdt(ddt);
        return new ResponseEntity<>(relazioni, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<RelazioneDdtProdotto> updateRelazioneDdtProdotto(@RequestBody RelazioneDdtProdotto relazione) throws IOException{
        RelazioneDdtProdotto updatedRelazione = relazioneService.updateRelazione(relazione);
        return new ResponseEntity<>(updatedRelazione, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRelazione(@PathVariable("id") int relazioneId){
        relazioneService.deleteRelazione(relazioneId);
        return new ResponseEntity<>("Relazione successfully deleted!", HttpStatus.OK);
    }
}
