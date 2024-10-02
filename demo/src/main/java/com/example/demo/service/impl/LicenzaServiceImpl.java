package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Licenza;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente;
import com.example.demo.repository.AziendaRepository;
import com.example.demo.repository.LicenzaRepository;
import com.example.demo.repository.RuoloRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.service.AziendaService;
import com.example.demo.service.LicenzaService;
import com.example.demo.service.RuoloService;
import com.example.demo.service.UtenteService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class LicenzaServiceImpl implements LicenzaService {

    private LicenzaRepository ruoloRepository;

    @Override
    public Licenza createRuolo(Licenza ruolo) {
        return ruoloRepository.save(ruolo);
    }

    @Override
    public Licenza getRuoloById(Long ruoloId) {
        Optional<Licenza> optionalRuolo = ruoloRepository.findById(ruoloId);
        return optionalRuolo.get();
    }
    
    @Override
    public Licenza getRuoloByDescrizione(String ruoloId) {
        Optional<Licenza> optionalRuolo = ruoloRepository.findByDescrizione(ruoloId);
        return optionalRuolo.get();
    }

    @Override
    public List<Licenza> getAllRuoli() {
        return ruoloRepository.findByUtilizzato(false);
    }

    //senza id?
    @Override
    public Licenza updateRuolo(Licenza ruolo) {
    	
    	/*Utente existingUtente = utenteRepository.findById(utente.getId()).get();
        existingUtente.setNome(utente.getNome());        
        Utente updatedUtente = utenteRepository.save(existingUtente);*/
        return ruoloRepository.save(ruolo);
    }

    @Override
    public void deleteRuolo(Long ruoloId) {
    	ruoloRepository.deleteById(ruoloId);
    }
}
