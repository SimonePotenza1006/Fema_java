package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ticket;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.MerceInRiparazione;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
    List<Ticket> findAllByOrderByIdDesc();
    //List<Ticket> findByCliente(Cliente cliente);
    List<Ticket> findByUtente(Utente utente);
}
