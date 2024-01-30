package com.example.demo.service;

import com.example.demo.entity.CategoriaInterventoSpecifico;
import com.example.demo.entity.TipologiaIntervento;

import java.util.List;
import java.util.Optional;

public interface CategoriaInterventoSpecificoService {
    
    CategoriaInterventoSpecifico createCategoriaInterventoSpecifico(CategoriaInterventoSpecifico categoriaInterventoSpecifico);

    CategoriaInterventoSpecifico getCategoriaInterventoSpecificoById(int categoriaInterventoSpecificoId);

    List<CategoriaInterventoSpecifico> getAllCategorieInterventoSpecifiche();

    List<Optional<CategoriaInterventoSpecifico>> getCategoriaSpecificaByTipologia(TipologiaIntervento tipologiaIntervento);

    CategoriaInterventoSpecifico updateCategoriaInterventoSpecifico(CategoriaInterventoSpecifico categoriaInterventoSpecifico);

    void deleteCategoriaInterventoSpecifico(int categoriaInterventoSpecificoId);
}
