package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.GruppoInterventi;

public interface InterventoService {
    
    Intervento createIntervento(Intervento intervento);

    Intervento getInterventoById(int interventoId);

    List<Intervento> getAllInterventi();

    List<Optional<Intervento>> getInterventoByCliente(Cliente cliente);

    List<Optional<Intervento>> getInterventoByUtente(Utente utente);

    List<Optional<Intervento>> getInterventoByTipologia(TipologiaIntervento tipologiaIntervento);

    List<Optional<Intervento>> getInterventiByGruppo(GruppoInterventi gruppo);

    List<Intervento> getInterventiByMerce(MerceInRiparazione merce);

    List<Intervento> getAllInterventiOrderdByDesc();

    List<Intervento> getInterventiOrderedByGruppo();

    Intervento updateIntervento(Intervento intervento);

    void deleteIntervento(int interventoId);
}