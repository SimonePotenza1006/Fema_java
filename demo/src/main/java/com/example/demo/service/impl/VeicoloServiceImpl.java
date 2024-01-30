package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Veicolo;
import com.example.demo.service.VeicoloService;
import com.example.demo.repository.VeicoloRepository;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VeicoloServiceImpl implements VeicoloService{
    
    private VeicoloRepository veicoloRepository;

    @Override
    public Veicolo createVeicolo(Veicolo veicolo) {
        return veicoloRepository.save(veicolo);
    }

    @Override
    public Veicolo getVeicoloById(int veicoloId) {
        Optional<Veicolo> optionalVeicolo = veicoloRepository.findById(veicoloId);
        return optionalVeicolo.get();
    }

    @Override
    public List<Veicolo> getAllVeicoli() {
        return veicoloRepository.findAll();
    }

    //senza id?
    @Override
    public Veicolo updateVeicolo(Veicolo veicolo) {
    	
    	/*Utente existingUtente = utenteRepository.findById(utente.getId()).get();
        existingUtente.setNome(utente.getNome());        
        Utente updatedUtente = utenteRepository.save(existingUtente);*/
        return veicoloRepository.save(veicolo);
    }

    @Override
    public void deleteVeicolo(int veicoloId) {
    	veicoloRepository.deleteById(veicoloId);
    }
}
