package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Veicolo;
import com.example.demo.entity.SpesaVeicolo;


public interface SpesaVeicoloService {
    
    SpesaVeicolo createSpesa(SpesaVeicolo spesaVeicolo);

    SpesaVeicolo getSpesaById(int id);

    List<SpesaVeicolo> getAllSpese();

    List<Optional<SpesaVeicolo>> getSpeseVeicoloByUtente(Utente utente);

    List<Optional<SpesaVeicolo>> getSpeseVeicoloByVeicolo(Veicolo veicolo);

    List<SpesaVeicolo> getAllSpesaVeicoloOrderByDesc();

    SpesaVeicolo updateSpesa(SpesaVeicolo spesaVeicolo);
    
    void deleteSpesa(int spesaId);
}
