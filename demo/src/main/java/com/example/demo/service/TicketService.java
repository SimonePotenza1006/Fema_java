package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.Utente;

public interface TicketService {
    
    Ticket createTicket(Ticket ticket);

    Ticket getTicketById(int ticketId);

    List<Ticket> getAllTicket();

    //List<Ticket> getAllTicketByCliente(Cliente cliente);

    List<Ticket> getAllTicketByUtente(Utente utente);
}
