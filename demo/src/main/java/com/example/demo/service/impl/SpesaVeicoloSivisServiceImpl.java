package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.UtenteSivis;
import com.example.demo.entity.VeicoloSivis;
import com.example.demo.entity.SpesaVeicoloSivis;
import com.example.demo.entity.SpesaVeicoloSivis;
import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.example.demo.repository.SpesaVeicoloRepository;
import com.example.demo.repository.SpesaVeicoloSivisRepository;
import com.example.demo.service.SpesaVeicoloSivisService;

@Service
@AllArgsConstructor
public class SpesaVeicoloSivisServiceImpl implements SpesaVeicoloSivisService{
    
    @Autowired
    private SpesaVeicoloSivisRepository spesaRepository;

    @Override
    public SpesaVeicoloSivis createSpesa(SpesaVeicoloSivis spesa){
        return spesaRepository.save(spesa);
    }

    @Override
    public SpesaVeicoloSivis getSpesaById(int spesaId){
        Optional<SpesaVeicoloSivis> optionalSpesa = spesaRepository.findById(spesaId);
        return optionalSpesa.get();
    }

    @Override
    public List<SpesaVeicoloSivis> getAllSpese(){
        return spesaRepository.findAll();
    }

    @Override
    public SpesaVeicoloSivis updateSpesa(SpesaVeicoloSivis spesa){
        return spesaRepository.save(spesa);
    }

    @Override
    public void deleteSpesa(int spesaId){
        spesaRepository.deleteById(spesaId);
    }
}
