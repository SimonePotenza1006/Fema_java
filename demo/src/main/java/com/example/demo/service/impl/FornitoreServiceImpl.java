package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Fornitore;
import com.example.demo.entity.Ruolo;
import com.example.demo.repository.FornitoreRepository;
import com.example.demo.service.FornitoreService;

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
public class FornitoreServiceImpl implements FornitoreService{
    
    @Autowired
    private FornitoreRepository fornitoreRepository;

    @Override
    public Fornitore createFornitore(Fornitore fornitore) {
        return fornitoreRepository.save(fornitore);
    }

    @Override
    public Fornitore getFornitoreById(int fornitoreId) {
        Optional<Fornitore> optionalFornitore = fornitoreRepository.findById(fornitoreId);
        return optionalFornitore.get();
    }

    @Override
    public List<Fornitore> getAllFornitori() {
        return fornitoreRepository.findAll();
    }

    //senza id?
    @Override
    public Fornitore updateFornitore(Fornitore fornitore) {
        return fornitoreRepository.save(fornitore);
    }

    @Override
    public void deleteFornitore(int fornitoreId) {
    	fornitoreRepository.deleteById(fornitoreId);
    }
}
