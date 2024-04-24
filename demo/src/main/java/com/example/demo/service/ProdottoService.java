package com.example.demo.service;

import com.example.demo.entity.Prodotto;
import com.example.demo.entity.CategoriaProdotto;
import com.example.demo.entity.Fornitore;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface ProdottoService {
    
    Prodotto createProdotto(Prodotto prodotto);

    Prodotto getProdottoById(int prodottoId);

    Optional<Prodotto> getProdottoForDDT(String codice_danea, String lotto_seriale);

    List<Prodotto> getAllProdotti();

    Prodotto updateProdotto(Prodotto prodotto);

    void deleteProdotto(int prodottoId);
}
