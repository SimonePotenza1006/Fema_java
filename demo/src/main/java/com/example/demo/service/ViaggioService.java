package com.example.demo.service;

import com.example.demo.entity.Utente;
import com.example.demo.entity.Viaggio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ViaggioService {
    
    Viaggio createViaggio(Viaggio viaggio);

	Viaggio getViaggioById(int viaggioId);
	
	//List<Optional<Viaggio>> getViaggioByUtente(Utente utente);

    List<Viaggio> getAllViaggi();

    Viaggio updateViaggio(Viaggio viaggio);

    void deleteViaggio(int viaggioId);
}
