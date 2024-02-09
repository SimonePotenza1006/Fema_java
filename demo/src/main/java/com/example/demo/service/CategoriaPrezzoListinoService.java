package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.CategoriaInterventoSpecifico;
import com.example.demo.entity.CategoriaPrezzoListino;


public interface CategoriaPrezzoListinoService {
    
    CategoriaPrezzoListino createCategoriaPrezzoListino(CategoriaPrezzoListino categoriaPrezzoListino);

    CategoriaPrezzoListino getCategoriaPrezzoListinoById(int categoriaPrezzoListinoId);

    List<CategoriaPrezzoListino> getAllCategoriePrezzoListini();

    List<Optional<CategoriaPrezzoListino>> getPrezzoListinoByCategoria(CategoriaInterventoSpecifico categoriaInterventoSpecifico);

    CategoriaPrezzoListino updateCategoriaPrezzoListino(CategoriaPrezzoListino categoriaPrezzoListino);

    void deleteCategoriaPrezzoListino(int categoriaPrezzoListinoId);
}
