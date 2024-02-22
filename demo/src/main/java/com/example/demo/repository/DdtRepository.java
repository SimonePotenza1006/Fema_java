package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CategoriaDDT;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Ddt;
import com.example.demo.entity.Destinazione;
import com.example.demo.entity.Utente;

import java.util.List;
import java.util.Optional;


@Repository
public interface DdtRepository extends JpaRepository<Ddt, Integer>{
    List<Optional<Ddt>> findByCategoriaDdt(CategoriaDDT categoriaDdt);
    List<Optional<Ddt>> findByCliente(Cliente cliente);
    List<Optional<Ddt>> findByDestinazione(Destinazione destinazione);
    List<Optional<Ddt>> findByUtente(Utente utente);
}
