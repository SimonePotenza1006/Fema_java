package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Ingresso;
import com.example.demo.entity.Utente;

public interface IngressoService {
    
    Ingresso createIngresso(Ingresso ingresso);

    Ingresso getIngressoById(int id);

    List<Ingresso> getAllIngressi();

    List<Optional<Ingresso>> getIngressiByUtente(Utente utente);
    
    List<Ingresso> getAllIngressiOrderByDesc();
}
