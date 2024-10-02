package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Device;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente;
import com.example.demo.repository.AziendaRepository;
import com.example.demo.repository.DeviceRepository;
import com.example.demo.repository.RuoloRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.service.AziendaService;
import com.example.demo.service.DeviceService;
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
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository ruoloRepository;

    @Override
    public Device createRuolo(Device ruolo) {
        return ruoloRepository.save(ruolo);
    }

    @Override
    public Device getRuoloById(Long ruoloId) {
        Optional<Device> optionalRuolo = ruoloRepository.findById(ruoloId);
        return optionalRuolo.get();
    }

    @Override
    public List<Device> getAllRuoli() {
        return ruoloRepository.findAll();
    }

    //senza id?
    @Override
    public Device updateRuolo(Device ruolo) {
    	
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
