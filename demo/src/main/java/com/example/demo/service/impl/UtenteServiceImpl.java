package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Ruolo;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.repository.RuoloRepository;
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
public class UtenteServiceImpl implements UtenteService{
    
    private UtenteRepository utenteRepository;
    private RuoloRepository ruoloRepository;

    @Override
    public ApiResponse login(Utente utente) {
        Utente user = utenteRepository.findByEmail(utente.getEmail());
        if(user == null) {
            throw new RuntimeException("User does not exist.");
            //return new ApiResponse(100, "User does not exist", null) ;
        }
        if(!user.getPassword().equals(utente.getPassword())){
            throw new RuntimeException("Password mismatch.");
            //return new ApiResponse(150, "Password mismatch", null) ;
        }
        return new ApiResponse(200, "Login success", null) ;
    }   

    @Override
    public Utente ulogin(Utente utente) {
        Utente user = utenteRepository.findByEmail(utente.getEmail());
        if(user == null) {
            throw new RuntimeException("User does not exist.");
            //return new ApiResponse(100, "User does not exist", null) ;
        }
        if(!user.getPassword().equals(utente.getPassword())){
            throw new RuntimeException("Password mismatch.");
            //return new ApiResponse(150, "Password mismatch", null) ;
        }
        return user ;
    }     
    

    @Override
    public Utente createUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    @Override
    public Utente getUtenteById(int utenteId) {
        Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
        return optionalUtente.get();
    }

    @Override
    public Utente getUtenteByEmail(String utenteEmail) {
        Utente utente = utenteRepository.findByEmail(utenteEmail);
        return utente;
    }

    @Override
    public List<Utente> getUtentiTecnici() {
    	
    	Optional<Ruolo> ruolo = ruoloRepository.findById(Integer.valueOf(2));
        return utenteRepository.findByRuolo(ruolo.get());
    }

    @Override
    public List<Utente> getAllUtenti() {
        //return utenteRepository.findAll();
    	return utenteRepository.findByAttivo(true);
    }

    @Override
    public Utente updateUtente(Utente utente) {
    	
    	/*Utente existingUtente = utenteRepository.findById(utente.getId()).get();
        existingUtente.setNome(utente.getNome());        
        Utente updatedUtente = utenteRepository.save(existingUtente);*/
        return utenteRepository.save(utente);
    }

    @Override
    public void deleteUtente(int utenteId) {
    	utenteRepository.deleteById(utenteId);
    }

}
