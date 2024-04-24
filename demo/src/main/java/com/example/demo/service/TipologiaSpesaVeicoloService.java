package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.TipologiaSpesaVeicolo;

public interface TipologiaSpesaVeicoloService {
    
    TipologiaSpesaVeicolo createTipologia(TipologiaSpesaVeicolo tipologia);

    TipologiaSpesaVeicolo getTipologiaSpesaVeicoloById (int tipologiaId);

    List<TipologiaSpesaVeicolo> getAllTipologie();

    TipologiaSpesaVeicolo updateTipologia(TipologiaSpesaVeicolo tipologia);

    void deleteTipologia(int tipologiaId);
} 
