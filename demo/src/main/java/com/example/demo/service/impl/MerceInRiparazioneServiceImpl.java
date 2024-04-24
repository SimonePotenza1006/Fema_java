package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Utente;
import com.example.demo.entity.MerceInRiparazione;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import com.example.demo.repository.MerceInRiparazioneRepository;
import com.example.demo.service.MerceInRiparazioneService;


@Service
@AllArgsConstructor
public class MerceInRiparazioneServiceImpl implements MerceInRiparazioneService{
    
    @Autowired
    private MerceInRiparazioneRepository merceRepository;

    @Override
    public MerceInRiparazione createMerce(MerceInRiparazione merce){
        return merceRepository.save(merce);
    }

    @Override
    public List<MerceInRiparazione> getAllMerciOrderByIdDesc(){
        List<MerceInRiparazione> optionalMerci = merceRepository.findAllByOrderByIdDesc();
        return optionalMerci;
    }

    @Override
    public MerceInRiparazione getMerceById(int merceId){
        Optional<MerceInRiparazione> optionalMerce = merceRepository.findById(merceId);
        return optionalMerce.get();
    }

    @Override
    public List<MerceInRiparazione> getAllMerce(){
        return merceRepository.findAll();
    } 

    @Override
    public List<Optional<MerceInRiparazione>> getMerciByUtente(Utente utente){
        List<Optional<MerceInRiparazione>> optionalMerci = merceRepository.findByUtente(utente);
        return optionalMerci;
    }

    @Override
    public void deleteMerce(int merceId){
        merceRepository.deleteById(merceId);
    }
}
