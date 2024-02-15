package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.CredenzialiCliente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Utente;

public interface CredenzialiClienteService {
    CredenzialiCliente createCredenzialiCliente(CredenzialiCliente credenzialiCliente);

    CredenzialiCliente getCredenzialiClienteById(int id);

    List<CredenzialiCliente> getAllCredenzialiClienti();

    List<Optional<CredenzialiCliente>> getCredenzialiByUtente(Utente utente);

    List<Optional<CredenzialiCliente>> getCredenzialiByCliente(Cliente cliente);

    CredenzialiCliente updateCredenzialiCliente(CredenzialiCliente credenzialiCliente);

    void deleteCredenzialiCliente(int credenzialiClienteId);
}

 