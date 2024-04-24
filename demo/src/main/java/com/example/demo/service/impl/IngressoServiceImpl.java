package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ingresso;
import com.example.demo.entity.Utente;
import com.example.demo.repository.IngressoRepository;
import com.example.demo.service.IngressoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IngressoServiceImpl implements IngressoService{
    
    @Autowired
    private IngressoRepository ingressoRepository;

    @Override
    public Ingresso createIngresso(Ingresso ingresso){
        return ingressoRepository.save(ingresso);
    }

    @Override
    public Ingresso getIngressoById(int ingressoId){
        Optional<Ingresso> optionalIngresso = ingressoRepository.findById(ingressoId);
        return optionalIngresso.get();
    }

    @Override
    public List<Ingresso> getAllIngressi(){
        return ingressoRepository.findAll();
    }

    @Override
    public List<Optional<Ingresso>> getIngressiByUtente(Utente utente){
        List<Optional<Ingresso>> optionalIngressi = ingressoRepository.findByUtente(utente);
        return optionalIngressi;
    }

    @Override
    public List<Ingresso> getAllIngressiOrderByDesc(){
        List<Ingresso> optionalIngressi = ingressoRepository.findAllByOrderByIdDesc();
        return optionalIngressi;
    }
}
