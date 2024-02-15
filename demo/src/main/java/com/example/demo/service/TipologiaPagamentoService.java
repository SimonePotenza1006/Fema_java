package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TipologiaPagamento;

public interface TipologiaPagamentoService {

    TipologiaPagamento createTipologiaPagamento(TipologiaPagamento tipologiaPagamento);

    TipologiaPagamento getTipologiaPagamentoById(int tipologiaPagamentoId);

    List<TipologiaPagamento> getAllTipologiePagamento();
    
    TipologiaPagamento updateTipologiaPagamento(TipologiaPagamento tipologiaPagamento);

    void deleteTipologiaPagamento(int tipologiaPagamentoId);
}
