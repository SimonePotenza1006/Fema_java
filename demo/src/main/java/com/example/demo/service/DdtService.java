package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.CategoriaDDT;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Ddt;
import com.example.demo.entity.Destinazione;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Utente;

public interface DdtService {
    
    Ddt createDdt(Ddt ddt);

    Ddt getDdtById(int ddtId);

    List<Ddt> getAllDdt();

    List<Optional<Ddt>> getDdtByCategoriaDdt(CategoriaDDT categoriaDdt);

    List<Optional<Ddt>> getDdtByCliente(Cliente cliente);

    List<Optional<Ddt>> getDdtByDestinazione(Destinazione destinazione);

    Optional<Ddt> getDdtByIntervento(Intervento intervento);

    List<Optional<Ddt>> getDdtByUtente(Utente utente);

    Ddt updateDdt (Ddt ddt);

    void deleteDdt(int ddtId);
}
