package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Destinazione;
import com.example.demo.entity.Spesa;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.DestinazioneRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;
import com.example.demo.service.DestinazioneService;;


@Service
@AllArgsConstructor
public class DestinazioneServiceImpl implements DestinazioneService{

    private DestinazioneRepository destinazioneRepository;
    private ClienteRepository clienteRepository;

    @Override
    public Destinazione createDestinazione(Destinazione destinazione) {
    	
        return destinazioneRepository.save(destinazione);
    }

    @Override
    public Destinazione getDestinazioneById(int destinazioneId) {
        Optional<Destinazione> optionalDestinazione = destinazioneRepository.findById(destinazioneId);
        return optionalDestinazione.get();
    }

    @Override
    public List<Destinazione> getAllDestinazioni() {
        return destinazioneRepository.findAll();
    }

    @Override
    public List<Optional<Destinazione>> getDestinazioneByCliente(Cliente cliente) {
        return destinazioneRepository.findDestinazioneByCliente(cliente);
    }

    @SuppressWarnings("null")
    @Override
    public Destinazione updateDestinazione(Destinazione destinazione) {
        return destinazioneRepository.save(destinazione);
    }
    
    @Override
    public void deleteDestinazione(int destinazioneId) {
    	destinazioneRepository.deleteById(destinazioneId);
    }    
}
