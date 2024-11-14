package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.FasiRiparazione;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.repository.FasiRiparazioneRepository;
import com.example.demo.service.FasiRiparazioneService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FasiRiparazioneServiceImpl implements FasiRiparazioneService{
    
    private final FasiRiparazioneRepository fasiRepository;

    @Override
    public FasiRiparazione createFase(FasiRiparazione fase){
        return fasiRepository.save(fase);
    }

    @Override
    public List<FasiRiparazione> getFasiByMerce(MerceInRiparazione merce){
        return fasiRepository.findByMerce(merce);
    }

    @Override
    public void deleteFase(int faseId){
        fasiRepository.deleteById(faseId);
    }
}
