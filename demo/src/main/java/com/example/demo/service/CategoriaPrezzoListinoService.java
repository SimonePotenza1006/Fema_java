package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CategoriaPrezzoListino;


public interface CategoriaPrezzoListinoService {
    
    CategoriaPrezzoListino createCategoriaPrezzoListino(CategoriaPrezzoListino categoriaPrezzoListino);

    CategoriaPrezzoListino getCategoriaPrezzoListinoById(int categoriaPrezzoListinoId);

    List<CategoriaPrezzoListino> getAllCategoriePrezzoListini();

    CategoriaPrezzoListino updateCategoriaPrezzoListino(CategoriaPrezzoListino categoriaPrezzoListino);

    void deleteCategoriaPrezzoListino(int categoriaPrezzoListinoId);
}
