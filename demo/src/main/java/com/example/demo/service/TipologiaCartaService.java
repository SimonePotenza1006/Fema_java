package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TipologiaCarta;
import com.example.demo.entity.CartaDiCredito;

public interface TipologiaCartaService {
    
    TipologiaCarta createTipologiaCarta(TipologiaCarta tipologiaCarta);

    TipologiaCarta getTipologiaCartaById(int TipologiaCartaId);

    List<TipologiaCarta> getAllTipologieCarta();

    TipologiaCarta updateTipologiaCarta(TipologiaCarta tipologiaCarta);

    void deleteTipologiaCarta(int TipologiaCartaId);

}
