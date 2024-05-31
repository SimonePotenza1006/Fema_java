package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Scadenza;

public interface ScadenzaService {
    
    Scadenza createScadenza(Scadenza scadenza);

    Scadenza getScadenzaById(int scadenzaId);

    List<Scadenza> getAllScadenze();

    List<Optional<Scadenza>> getScadenzaByCliente(Cliente cliente);

    List<Scadenza> getAllScadenzeOrderByDesc();

    void deleteScadenza(int scadenzaId);
}
