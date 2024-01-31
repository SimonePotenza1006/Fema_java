package com.example.demo.service;

import com.example.demo.entity.Fornitore;

import java.util.List;
import java.util.Set;

public interface FornitoreService {
    
    Fornitore createFornitore(Fornitore fornitore);

    Fornitore getFornitoreById(int fornitoreId);

    List<Fornitore> getAllFornitori();

    Fornitore updateFornitore(Fornitore fornitore);

    void deleteFornitore(int fornitoreId);
}
