package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ScadenzaRepository;
import com.example.demo.service.ScadenzaService;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Scadenza;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScadenzaServiceImpl implements ScadenzaService{
    
    @Autowired
    private ScadenzaRepository scadenzaRepository;
    
    @Override
    public Scadenza createScadenza(Scadenza scadenza){
        return scadenzaRepository.save(scadenza);
    }

    @Override
    public List<Scadenza> getAllScadenzeOrderByDesc(){
        List<Scadenza> optionalScadeze = scadenzaRepository.findAllByOrderByIdDesc();
        return optionalScadeze;
    }

    @Override
    public Scadenza getScadenzaById(int scadenzaId){
        Optional<Scadenza> optionalScadenza = scadenzaRepository.findById(scadenzaId);
        return optionalScadenza.get();
    }

    @Override
    public List<Scadenza> getAllScadenze(){
        return scadenzaRepository.findAll();
    }

    @Override 
    public List<Optional<Scadenza>> getScadenzaByCliente(Cliente cliente){
        List<Optional<Scadenza>> optionalScadenza = scadenzaRepository.findByCliente(cliente);
        return optionalScadenza;
    }

    @Override 
    public void deleteScadenza(int scadenzaId){
        scadenzaRepository.deleteById(scadenzaId);
    }
}
