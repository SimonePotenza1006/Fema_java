package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.OrdinePerIntervento;
import com.example.demo.entity.Utente;

public interface OrdinePerInterventoService {
    
    OrdinePerIntervento createOrdine(OrdinePerIntervento ordinePerIntervento);

    OrdinePerIntervento getOrdineById(int ordineId);

    List<OrdinePerIntervento> getAllOrdini();

    List<OrdinePerIntervento> getAllOrdiniOrderByDesc();

    List<Optional<OrdinePerIntervento>> getOrdineByUtente(Utente utente);

    List<Optional<OrdinePerIntervento>> getOrdineByIntervento(Intervento intervento);

    List<Optional<OrdinePerIntervento>> getOrdineByCliente(Cliente cliente);

    OrdinePerIntervento updateOrdine(OrdinePerIntervento ordine);

    void deleteOrdine(int ordineId);
}
