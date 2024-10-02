package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Ticket;

public interface TicketService {
    
    Ticket createTicket(Ticket ticket);

    Ticket getTicketById(int ticketId);

    Ticket getAllTicket();

    List<Ticket> getAllTicketNonConclusi();

    List<Ticket> getAllTicketByCliente(Cliente cliente);
}
