package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Attivita;
import com.example.demo.service.AttivitaService;
import com.example.demo.repository.AttivitaRepository;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class AttivitaServiceImpl implements AttivitaService{
    
    private AttivitaRepository attivitaRepository;

    @Override
    public Attivita createAttivita(Attivita attivita){
        return attivitaRepository.save(attivita);
    }

    @Override
    public Attivita getAttivitaById(int attivitaId) {
        Optional<Attivita> optionalAttivita = attivitaRepository.findById(attivitaId);
        return optionalAttivita.get();
    }

    @Override
    public List<Attivita> getAllAttivita() {
        return attivitaRepository.findAll();
    }

    @Override
    public Attivita updateAttivita(Attivita attivita){
        return attivitaRepository.save(attivita);
    }

    @Override
    public void deleteAttivita(int attivitaId) {
        attivitaRepository.deleteById(attivitaId);
    }
}
