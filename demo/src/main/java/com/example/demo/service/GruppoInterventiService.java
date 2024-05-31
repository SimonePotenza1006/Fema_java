package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.GruppoInterventi;

public interface GruppoInterventiService {
    
    GruppoInterventi createGruppo(GruppoInterventi gruppo);

    GruppoInterventi getGruppoById(int id);

    List<GruppoInterventi> getAllGruppiIntervento();

    List<Optional<GruppoInterventi>> getGruppiByCliente(Cliente cliente);

    List<GruppoInterventi> getAllGruppiOrderedByDesc();

    void deleteGruppo(int id);
}
