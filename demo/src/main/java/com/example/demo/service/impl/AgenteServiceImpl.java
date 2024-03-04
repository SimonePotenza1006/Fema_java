package com.example.demo.service.impl;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Agente;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.AgenteRepository;
import com.example.demo.service.AgenteService;

@Service
@AllArgsConstructor
public class AgenteServiceImpl implements AgenteService{
    
    private final AgenteRepository agenteRepository;

    @Override
    public Agente createAgente(Agente agente) {
        return agenteRepository.save(agente);
    }

    @Override
    public Agente getAgenteById(int agenteId) {
        Optional<Agente> optionalAgente = agenteRepository.findById(agenteId);
        return optionalAgente.orElse(null); 
    }

    @Override
    public List<Agente> getAllAgenti() {
        return agenteRepository.findAll();
    }

    @Override
    public Agente updateAgente(Agente agente) {
        return agenteRepository.save(agente);
    }

    @Override
    public void deleteAgente(int agenteId) {
        agenteRepository.deleteById(agenteId);
    }
}
