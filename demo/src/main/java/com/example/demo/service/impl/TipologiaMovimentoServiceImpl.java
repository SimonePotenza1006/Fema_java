package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TipologiaMovimento;
import com.example.demo.repository.TipologiaMovimentoRepository;
import com.example.demo.service.TipologiaMovimentoService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TipologiaMovimentoServiceImpl implements TipologiaMovimentoService{
    
    @Autowired
    private TipologiaMovimentoRepository tipologiaRepository;

    @Override
    public TipologiaMovimento createTipologia(TipologiaMovimento tipologia){
        return tipologiaRepository.save(tipologia);
    }

    @Override
    public List<TipologiaMovimento> getAllTipologie(){
        return tipologiaRepository.findAll();
    }

    @Override
    public TipologiaMovimento updateTipologia(TipologiaMovimento tipologia){
        return tipologiaRepository.save(tipologia);
    }

    @Override
    public void deleteTipologia(int tipologiaId){
        tipologiaRepository.deleteById(tipologiaId);
    }
}
