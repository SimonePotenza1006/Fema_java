package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TipologiaMovimento;

public interface TipologiaMovimentoService {
    
    TipologiaMovimento createTipologia(TipologiaMovimento tipologia);

    List<TipologiaMovimento> getAllTipologie();

    TipologiaMovimento updateTipologia(TipologiaMovimento tipologia);

    void deleteTipologia(int tipologiaId);
}
