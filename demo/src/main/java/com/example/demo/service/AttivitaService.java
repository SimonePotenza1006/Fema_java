package com.example.demo.service;

import com.example.demo.entity.Attivita;

import java.util.List;
import java.util.Set;

public interface AttivitaService {
    
    Attivita createAttivita(Attivita attivita);

	Attivita getAttivitaById(int attivitaId);

    List<Attivita> getAllAttivita();

    Attivita updateAttivita(Attivita attivita);

    void deleteAttivita(int attivitaId);
}
