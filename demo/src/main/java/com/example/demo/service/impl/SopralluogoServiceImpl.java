package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.repository.SopralluogoRepository;
import com.example.demo.service.SopralluogoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SopralluogoServiceImpl implements SopralluogoService{
    
    @Autowired
    private SopralluogoRepository sopralluogoRepository;

    @Override
    public Sopralluogo createSopralluogo(Sopralluogo sopralluogo){
        return sopralluogoRepository.save(sopralluogo);
    }

    @Override
    public List<Sopralluogo> getAllSopralluoghiOrderByDesc() {
        List<Sopralluogo> optionalSoprallluoghi = sopralluogoRepository.findAllByOrderByIdDesc();
        return optionalSoprallluoghi;
    }

    @Override
    public Sopralluogo getSopralluogoById(int sopralluogoId){
        Optional<Sopralluogo> optionalSopralluogo = sopralluogoRepository.findById(sopralluogoId);
        return optionalSopralluogo.get();
    }

    @Override
    public List<Sopralluogo> getAllSopralluoghi(){
        return sopralluogoRepository.findAll();
    }

    @Override 
    public List<Optional<Sopralluogo>> getSopralluogoByUtente(Utente utente){
        List<Optional<Sopralluogo>> optionalSopralluogo = sopralluogoRepository.findByUtente(utente);
        return optionalSopralluogo;
    }

    @Override
    public List<Optional<Sopralluogo>> getSopralluogoByCliente(Cliente cliente){
        List<Optional<Sopralluogo>> optionalSopralluogo = sopralluogoRepository.findByCliente(cliente);
        return optionalSopralluogo;
    }

    @Override
    public List<Optional<Sopralluogo>> getSopralluogoByTipologia(TipologiaIntervento tipologia){
        List<Optional<Sopralluogo>> optionalSopralluogo = sopralluogoRepository.findByTipologia(tipologia);
        return optionalSopralluogo;
    }

    @Override
    public Sopralluogo updateSopralluogo(Sopralluogo sopralluogo){
        return sopralluogoRepository.save(sopralluogo);
    }

    @Override
    public void deleteSopralluogo(int sopralluogoId){
        sopralluogoRepository.deleteById(sopralluogoId);
    }
}
