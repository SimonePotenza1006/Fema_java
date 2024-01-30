package com.example.demo.service;

import com.example.demo.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    
    Cliente createCliente(Cliente cliente);

    Cliente getClienteById(int clienteId);

    List<Cliente> getAllClienti();

    Cliente updateCliente(Cliente cliente);

    void deleteCliente(int clienteId);
}
