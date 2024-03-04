package com.example.demo.service.impl;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.AziendaRepository;
import com.example.demo.service.AziendaService;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AziendaServiceImpl implements AziendaService{
    
    private final AziendaRepository aziendaRepository;

    @Override
    public Azienda createAzienda(Azienda azienda) {
        return aziendaRepository.save(azienda);
    }

    @Override
    public Azienda getAziendaById(int aziendaId) {
        Optional<Azienda> optionalAzienda = aziendaRepository.findById(aziendaId);
        return optionalAzienda.orElse(null);
    }

    @Override
    public List<Azienda> getAllAziende() {
        return aziendaRepository.findAll();
    }

    @Override
    public Azienda updateAzienda(Azienda azienda) {
        return aziendaRepository.save(azienda);
    }

    @Override
    public void deleteAzienda(int aziendaId) {
        aziendaRepository.deleteById(aziendaId);
    }
}
