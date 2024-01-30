package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Ruolo;
import com.example.demo.service.ClienteService;
import com.example.demo.repository.ClienteRepository;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService{
    
    private ClienteRepository clienteRepository;

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente getClienteById(int clienteId) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(clienteId);
        return optionalCliente.get();
    }

    @Override
    public List<Cliente> getAllClienti() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(int clienteId) {
    	clienteRepository.deleteById(clienteId);
    }
}
