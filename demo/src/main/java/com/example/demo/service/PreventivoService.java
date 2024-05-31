package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Agente;
import com.example.demo.entity.Azienda;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Preventivo;
import com.example.demo.entity.Utente;

public interface PreventivoService {
    
    Preventivo createPreventivo(Preventivo preventivo);

    Preventivo getPreventivoById(int preventivoId);

    List<Preventivo> getAllPreventivi();

    List<Optional<Preventivo>> getPreventivoByUtente(Utente utente);

    List<Optional<Preventivo>> getPreventivoByAgente(Agente agente);

    List<Optional<Preventivo>> getPreventivoByAzienda (Azienda azienda);

    List<Optional<Preventivo>> getPreventivoByCliente(Cliente cliente);

    List<Optional<Preventivo>> getAllPreventiviOrderedByAgente();

    List<Preventivo> getAllPreventiviOrderByDesc();

    Preventivo updatePreventivo(Preventivo preventivo);

    void deletePreventivo(int preventivoId);
}
