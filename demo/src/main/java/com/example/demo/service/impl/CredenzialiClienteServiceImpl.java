package com.example.demo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.demo.entity.CredenzialiCliente;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.service.CredenzialiClienteService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.ClienteService;
import com.example.demo.repository.CredenzialiClienteRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.repository.ClienteRepository;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredenzialiClienteServiceImpl implements CredenzialiClienteService{
    
    @Autowired
    private CredenzialiClienteRepository credenzialiRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @SuppressWarnings("null")
    @Override
    public CredenzialiCliente createCredenzialiCliente(CredenzialiCliente credenzialiCliente){
        return credenzialiRepository.save(credenzialiCliente);
    }

    @Override
    public CredenzialiCliente getCredenzialiClienteById(int credenzialiClienteId){
        Optional<CredenzialiCliente> optionalCredenziale = credenzialiRepository.findById(credenzialiClienteId);
        return optionalCredenziale.get();
    }

    @Override 
    public List<CredenzialiCliente> getAllCredenzialiClienti(){
        return credenzialiRepository.findAll();
    }

    @Override
    public List<Optional<CredenzialiCliente>> getCredenzialiByUtente(Utente utente){
        return credenzialiRepository.findByUtente(utente)
        .stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
    }

    @Override
    public List<Optional<CredenzialiCliente>> getCredenzialiByCliente(Cliente cliente){
        return credenzialiRepository.findByCliente(cliente)
        .stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public CredenzialiCliente updateCredenzialiCliente(CredenzialiCliente credenzialiCliente){
        return credenzialiRepository.save(credenzialiCliente);
    }

    @Override
    public void deleteCredenzialiCliente(int credenzialiClienteId){
        credenzialiRepository.deleteById(credenzialiClienteId);
    }
}
