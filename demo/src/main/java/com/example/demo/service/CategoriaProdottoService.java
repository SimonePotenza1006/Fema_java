package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.entity.CategoriaProdotto;

public interface CategoriaProdottoService {
    
    CategoriaProdotto createCategoriaProdotto(CategoriaProdotto categoriaProdotto);

    CategoriaProdotto getCategoriaProdottoById(int categoriaProdottoId);

    List<CategoriaProdotto> getAllCategorieProdotti();

    CategoriaProdotto updateCategoriaProdotto(CategoriaProdotto categoriaProdotto);

    void deleteCategoriaProdotto(int categoriaProdottoId);
}
