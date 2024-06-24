package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cartella;
import com.example.demo.repository.CartellaRepository;
import com.example.demo.service.CartellaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartellaServiceImpl implements CartellaService{
    
    private CartellaRepository cartellaRepository;

    @Override
    public Cartella createCartella(Cartella cartella){
        return cartellaRepository.save(cartella);
    }

    @Override
    public Cartella getCartellaById(int cartellaId){
        Optional<Cartella> optionalCartella = cartellaRepository.findById(cartellaId);
        return optionalCartella.get();
    }

    @Override
    public List<Cartella> getCartelleByParentFolder(Cartella cartella){
        List<Cartella> optionalCartella = cartellaRepository.findByParentFolder(cartella);
        return optionalCartella;
    }

    @Override
    public List<Cartella> getAllCartelle(){
        return cartellaRepository.findAll();
    }

    @Override
    public Cartella updateCartella(Cartella cartella){
        return cartellaRepository.save(cartella);
    }

    @Override
    public void deleteCartella(int cartellaId){
        cartellaRepository.deleteById(cartellaId);
    }
}
