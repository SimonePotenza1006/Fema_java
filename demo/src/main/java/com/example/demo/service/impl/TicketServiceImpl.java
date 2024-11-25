package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.Utente;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{
    
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(int ticketId){
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        return ticket.get();
    }

    @Override
    public List<Ticket> getAllTicket(){
        List<Ticket> tickets = ticketRepository.findAllByOrderByIdDesc();
        return tickets;
    }

    // @Override
    // public List<Ticket> getAllTicketByCliente(Cliente cliente){
    //     List<Ticket> tickets = ticketRepository.findByCliente(cliente);
    //     return tickets;
    // }

    @Override
    public List<Ticket> getAllTicketByUtente(Utente utente){
        List<Ticket> tickets = ticketRepository.findByUtente(utente);
        return tickets;
    }
}
