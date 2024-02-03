package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.OrdinePerIntervento;
import com.example.demo.entity.Utente;

public interface OrdinePerInterventoService {
    
    OrdinePerIntervento createOrdine(OrdinePerIntervento ordinePerIntervento);

    OrdinePerIntervento getOrdineById(int ordineId);

    List<OrdinePerIntervento> getAllOrdini();

    List<Optional<OrdinePerIntervento>> getOrdineByUtente(Utente utente);

    List<Optional<OrdinePerIntervento>> getOrdineByIntervento(Intervento intervento);

    OrdinePerIntervento updateOrdine(OrdinePerIntervento ordine);

    void deleteOrdine(int ordineId);
}
