package com.example.demo.repository;
import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Scadenza;
import com.example.demo.entity.Cliente;


@Repository
public interface ScadenzaRepository extends JpaRepository<Scadenza, Integer>{
    List<Scadenza> findAllByOrderByIdDesc();
    List<Optional<Scadenza>> findByCliente(Cliente cliente);
}
