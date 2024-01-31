package com.example.demo.service.impl;

import com.example.demo.repository.CategoriaProdottoRepository;
import com.example.demo.service.CategoriaProdottoService;

import lombok.AllArgsConstructor;

import com.example.demo.entity.CategoriaProdotto;
import com.example.demo.entity.Ruolo;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoriaProdottoServiceImpl implements CategoriaProdottoService {
    
    CategoriaProdottoRepository categoriaProdottoRepository;

    @Override
    public CategoriaProdotto createCategoriaProdotto(CategoriaProdotto categoriaProdotto) {
        return categoriaProdottoRepository.save(categoriaProdotto);
    }

    @Override
    public CategoriaProdotto getCategoriaProdottoById(int categoriaProdottoId) {
        Optional<CategoriaProdotto> optionalRuolo = categoriaProdottoRepository.findById(categoriaProdottoId);
        return optionalRuolo.get();
    }

    @Override
    public List<CategoriaProdotto> getAllCategorieProdotti() {
        return categoriaProdottoRepository.findAll();
    }

    //senza id?
    @Override
    public CategoriaProdotto updateCategoriaProdotto(CategoriaProdotto categoriaProdotto) {
    	
    	/*Utente existingUtente = utenteRepository.findById(utente.getId()).get();
        existingUtente.setNome(utente.getNome());        
        Utente updatedUtente = utenteRepository.save(existingUtente);*/
        return categoriaProdottoRepository.save(categoriaProdotto);
    }

    @Override
    public void deleteCategoriaProdotto(int categoriaProdottoId) {
    	categoriaProdottoRepository.deleteById(categoriaProdottoId);
    }
}
