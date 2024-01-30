package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Destinazione;
import com.example.demo.entity.Cliente;

public interface DestinazioneService {
    
    Destinazione createDestinazione(Destinazione destinazione);

    Destinazione getDestinazioneById(int destinazioneId);

    List<Destinazione> getAllDestinazioni();

    List<Optional<Destinazione>> getDestinazioneByCliente(Cliente cliente);

    Destinazione updateDestinazione(Destinazione destinazione);

    void deleteDestinazione(int destinazioneId);
}
