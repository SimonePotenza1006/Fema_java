package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.GruppoInterventi;
import com.example.demo.repository.GruppoInterventiRepository;
import com.example.demo.service.GruppoInterventiService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GruppoInterventiServiceImpl implements GruppoInterventiService{

    @Autowired
    private GruppoInterventiRepository gruppoRepository;

    @Override
    public GruppoInterventi createGruppo(GruppoInterventi gruppo){
        return gruppoRepository.save(gruppo);
    }

    @Override
    public GruppoInterventi getGruppoById(int id){
        Optional<GruppoInterventi> optionalGruppo = gruppoRepository.findById(id);
        return optionalGruppo.get();
    }

    @Override
    public List<GruppoInterventi> getAllGruppiIntervento(){
        return gruppoRepository.findAll();
    }

    @Override
    public List<GruppoInterventi> getAllGruppiOrderedByDesc(){
        List<GruppoInterventi> optionalGruppi = gruppoRepository.findAllByOrderByIdDesc();
        return optionalGruppi;
    }

    @Override
    public List<Optional<GruppoInterventi>> getGruppiByCliente(Cliente cliente){
        List<Optional<GruppoInterventi>> optionalGruppi = gruppoRepository.findByCliente(cliente);
        return optionalGruppi;
    }
    
    @Override
    public void deleteGruppo(int id){
        gruppoRepository.deleteById(id);
    }
}
