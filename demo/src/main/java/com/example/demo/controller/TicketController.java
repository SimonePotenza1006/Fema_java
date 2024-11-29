package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.Utente;
import com.example.demo.service.ClienteService;
import com.example.demo.service.ImmagineService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.impl.TicketServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/ticket")
public class TicketController {
    
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private ImmagineService immagineService;

    // @Autowired
    // private ClienteService clienteService;

    @Autowired
    private TicketServiceImpl ticketService;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
        Ticket savedTicket = ticketService.createTicket(ticket);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") int ticketId){
        int idvariable = ticketId;
        Ticket ticket = ticketService.getTicketById(idvariable);
        if(ticket == null){
            System.out.println("Ticket non trovato con ID: " + ticketId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Ticket non trovato con ID: " + ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> tickets = ticketService.getAllTicket();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Ticket>> getAllTicketsByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Ticket> tickets = ticketService.getAllTicketByUtente(utente);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable("id") int ticketId){
        immagineService.deleteByTicketId(ticketId);
        ticketService.deleteTicket(ticketId);
        return new ResponseEntity<>("Ticket succesfully deleted!", HttpStatus.OK);
    }
}
