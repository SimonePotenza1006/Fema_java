package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.CategoriaInterventoSpecifico;
import com.example.demo.entity.Spesa;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.repository.CategoriaInterventoSpecificoRepository;
import com.example.demo.repository.TipologiaInterventoRepository;
import com.example.demo.service.TipologiaCartaService;
import com.example.demo.service.CategoriaInterventoSpecificoService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.CategoriaInterventoSpecificoService;


@Service
public class CategoriaInterventoSpecificoServiceImpl implements CategoriaInterventoSpecificoService {
    
    @Autowired
    private CategoriaInterventoSpecificoRepository categoriaRepository;

    @Autowired
    private TipologiaInterventoRepository tipologiaRepository;

    @Override
    public CategoriaInterventoSpecifico createCategoriaInterventoSpecifico(CategoriaInterventoSpecifico categoriaInterventoSpecifico) {	
        return categoriaRepository.save(categoriaInterventoSpecifico);
    }

    @Override
    public CategoriaInterventoSpecifico getCategoriaInterventoSpecificoById(int categoriaInterventoSpecificoId) {
        Optional<CategoriaInterventoSpecifico> optionalCategoria = categoriaRepository.findById(categoriaInterventoSpecificoId);
        return optionalCategoria.get();
    }

    @Override
    public List<CategoriaInterventoSpecifico> getAllCategorieInterventoSpecifiche() {
        return categoriaRepository.findAll();
    }

    @Override
   public List<Optional<CategoriaInterventoSpecifico>> getCategoriaSpecificaByTipologia(TipologiaIntervento tipologiaIntervento) {
    return categoriaRepository.findByTipologiaIntervento(tipologiaIntervento)
                               .stream()
                               .filter(Objects::nonNull) // Rimuovi eventuali elementi null
                               .collect(Collectors.toList());
    }

    @Override
    public CategoriaInterventoSpecifico updateCategoriaInterventoSpecifico(CategoriaInterventoSpecifico categoriaInterventoSpecifico){
        return categoriaRepository.save(categoriaInterventoSpecifico);
    }

    @Override
    public void deleteCategoriaInterventoSpecifico(int categoriaInterventoSpecificoId){
        categoriaRepository.deleteById(categoriaInterventoSpecificoId);
    }
}
