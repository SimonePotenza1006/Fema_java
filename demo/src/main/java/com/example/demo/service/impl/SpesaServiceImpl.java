package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Spesa;
import com.example.demo.entity.Viaggio;
import com.example.demo.repository.SpesaRepository;
import com.example.demo.repository.ViaggioRepository;
import com.example.demo.service.SpesaService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SpesaServiceImpl implements SpesaService {
    
    private ViaggioRepository viaggioRepository;
    private SpesaRepository spesaRepository;

    @Override
    public Spesa createSpesa(Spesa spesa) {
        return spesaRepository.save(spesa);
    }

    @Override
    public Spesa getSpesaById(int spesaId) {
        Optional<Spesa> optionalSpesa = spesaRepository.findById(spesaId);
        return optionalSpesa.get();
    }

    @Override
    public List<Spesa> getAllSpese() {
        return spesaRepository.findAll();
    }

    @Override
    public List<Optional<Spesa>> getSpesaByViaggio(Viaggio viaggio) {
        return spesaRepository.findByViaggioOrderByIdDesc(viaggio);
    }

    @Override
    public Spesa updateSpesa(Spesa spesa) {
        return spesaRepository.save(spesa);
    }

    @Override
    public void deleteSpesa(int spesaId) {
    	spesaRepository.deleteById(spesaId);
    }

}
