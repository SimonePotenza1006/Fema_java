package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Spesa;
import com.example.demo.entity.Fornitore;
import com.example.demo.entity.CategoriaProdotto;
import com.example.demo.repository.ProdottoRepository;
import com.example.demo.repository.CategoriaProdottoRepository;
import com.example.demo.repository.FornitoreRepository;
import com.example.demo.service.ProdottoService;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class ProdottoServiceImpl implements ProdottoService{
    
    private ProdottoRepository prodottoRepository;
    private FornitoreRepository fornitoreRepository;
    private CategoriaProdottoRepository categoriaProdottoRepository;

    @Override
    public Prodotto createProdotto(Prodotto prodotto) {
        return prodottoRepository.save(prodotto);
    }

    @Override
    public Prodotto getProdottoById(int prodottoId){
        Optional<Prodotto> optionalProdotto = prodottoRepository.findById(prodottoId);
        return optionalProdotto.get();
    }

    @Override
    public List<Prodotto> getAllProdotti(){
        return prodottoRepository.findAll();
    }

    @Override
    public List<Optional<Prodotto>> getProdottoByFornitore(Fornitore fornitore){
        List<Optional<Prodotto>> optionalProdottoList = prodottoRepository.findByFornitore(fornitore);
        return optionalProdottoList;
    }

    @Override
    public List<Optional<Prodotto>> getProdottoByCategoria(CategoriaProdotto categoria){
        List<Optional<Prodotto>> prodotti = prodottoRepository.findByCategoriaProdotto(categoria);
        return prodotti;
    }

    @Override 
    public Prodotto updateProdotto(Prodotto prodotto){
        return prodottoRepository.save(prodotto);
    }

    @Override
    public void deleteProdotto(int prodottoId){
        prodottoRepository.deleteById(prodottoId);
    }
}