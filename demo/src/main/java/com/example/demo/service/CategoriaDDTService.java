package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CategoriaDDT;

public interface CategoriaDDTService {
    
    CategoriaDDT createCategoriaDDT(CategoriaDDT categoriaDDT);

    CategoriaDDT getCategoriaDDTById(int categoriaDDTId);

    List<CategoriaDDT> getAllCategorieDDT();

    CategoriaDDT updateCategoria(CategoriaDDT categoriaDDT);

    void deleteCategoria(int categoriaDDT);
}
