package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.UtenteSivis;
import com.example.demo.repository.UtenteSivisRepository;
import com.example.demo.service.UtenteSivisService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UtenteSivisServiceImpl implements UtenteSivisService{
    
    @Autowired
    private UtenteSivisRepository utenteRepository;

    @Override
    public ApiResponse login(UtenteSivis utente) {
        UtenteSivis user = utenteRepository.findByEmail(utente.getEmail());
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
    public UtenteSivis ulogin(UtenteSivis utente) {
        UtenteSivis user = utenteRepository.findByEmail(utente.getEmail());
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
    public UtenteSivis createUtente(UtenteSivis utente) {
        return utenteRepository.save(utente);
    }

    @Override
    public UtenteSivis getUtenteById(int utenteId) {
        Optional<UtenteSivis> optionalUtente = utenteRepository.findById(utenteId);
        return optionalUtente.get();
    }

    @Override
    public UtenteSivis getUtenteByEmail(String utenteEmail) {
        UtenteSivis utente = utenteRepository.findByEmail(utenteEmail);
        return utente;
    }

    @Override
    public UtenteSivis updateUtente(UtenteSivis utente) {
    	
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
