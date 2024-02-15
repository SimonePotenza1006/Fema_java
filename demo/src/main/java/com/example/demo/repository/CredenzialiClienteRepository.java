package com.example.demo.repository;
import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CredenzialiCliente;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;

@Repository
public interface CredenzialiClienteRepository extends JpaRepository<CredenzialiCliente, Integer>{
    Optional<CredenzialiCliente> findById(int id);
    List<Optional<CredenzialiCliente>> findByUtente(Utente utente);
    List<Optional<CredenzialiCliente>> findByCliente(Cliente cliente);
}
