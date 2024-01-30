package com.example.demo.service;

import com.example.demo.entity.TipologiaIntervento;

import java.util.List;
import java.util.Optional;

public interface TipologiaInterventoService {
    
    TipologiaIntervento createTipologiaIntervento(TipologiaIntervento tipologiaIntervento);

    TipologiaIntervento getTipologiaInterventoById(int tipologiaInterventoId);

    List<TipologiaIntervento> getAllTipologieIntervento();

    TipologiaIntervento updateTipologiaIntervento(TipologiaIntervento tipologiaIntervento);

    void deleteTipologiaIntervento(int tipologiaInterventoId);

}
