package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    
    private final ClienteRepository clienteRepository;

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente getClienteById(int clienteId) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(clienteId);
        return optionalCliente.orElse(null); // Gestione dell'opzionale vuoto
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
