package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.TipologiaCarta;
import com.example.demo.entity.CartaDiCredito;
import com.example.demo.service.TipologiaCartaService;
import com.example.demo.service.CartaDiCreditoService;
import com.example.demo.repository.CartaDiCreditoRepository;
import com.example.demo.repository.TipologiaCartaRepository;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;


@Service
@AllArgsConstructor
public class TipologiaCartaServiceImpl implements TipologiaCartaService {
    
    private TipologiaCartaRepository tipologiaCartaRepository;

    @Override
    public TipologiaCarta createTipologiaCarta(TipologiaCarta tipologiaCarta) {
        return tipologiaCartaRepository.save(tipologiaCarta);
    }

    @Override
    public TipologiaCarta getTipologiaCartaById(int tipologiaCartaId) {
        Optional<TipologiaCarta> optionalTipologiaCarta = tipologiaCartaRepository.findById(tipologiaCartaId);
        return optionalTipologiaCarta.get();
    }

    @Override
    public List<TipologiaCarta> getAllTipologieCarta() {
        return tipologiaCartaRepository.findAll();
    }

    @Override
    public TipologiaCarta updateTipologiaCarta(TipologiaCarta tipologiaCarta){
        return tipologiaCartaRepository.save(tipologiaCarta);
    }

    @Override
    public void deleteTipologiaCarta(int tipologiaCartaId){
        tipologiaCartaRepository.deleteById(tipologiaCartaId);
    }

}
