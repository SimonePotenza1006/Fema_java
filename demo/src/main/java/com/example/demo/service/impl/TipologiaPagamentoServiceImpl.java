package com.example.demo.service.impl;

import java.util.Optional;
import java.util.List;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TipologiaPagamento;
import com.example.demo.repository.TipologiaPagamentoRepository;
import com.example.demo.service.TipologiaPagamentoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipologiaPagamentoServiceImpl implements TipologiaPagamentoService{
    
    private TipologiaPagamentoRepository tipologiaPagamentoRepository;

    @Override
    public TipologiaPagamento createTipologiaPagamento(TipologiaPagamento tipologiaPagamento){
        return tipologiaPagamentoRepository.save(tipologiaPagamento);
    }

    @Override
    public TipologiaPagamento getTipologiaPagamentoById(int tipologiaPagamentoId){
        Optional<TipologiaPagamento> optionalTipologiaPagamento = tipologiaPagamentoRepository.findById(tipologiaPagamentoId);
        return optionalTipologiaPagamento.get();
    }

    @Override
    public List<TipologiaPagamento> getAllTipologiePagamento(){
        return tipologiaPagamentoRepository.findAll();
    }

    @Override
    public TipologiaPagamento updateTipologiaPagamento(TipologiaPagamento tipologiaPagamento){
        return tipologiaPagamentoRepository.save(tipologiaPagamento);
    }

    @Override
    public void deleteTipologiaPagamento(int tipologiaPagamentoId){
        tipologiaPagamentoRepository.deleteById(tipologiaPagamentoId);
    }
}
