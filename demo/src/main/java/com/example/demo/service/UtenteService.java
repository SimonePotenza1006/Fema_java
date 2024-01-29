package com.example.demo.service;

import com.example.demo.entity.Utente;
import com.example.demo.entity.ApiResponse;

import java.util.List;
import java.util.Set;

public interface UtenteService {
    
    ApiResponse login(Utente utente);

    Utente ulogin(Utente utente);

    Utente createUtente(Utente utente);

    Utente getUtenteById(int utenteId);

    Utente getUtenteByEmail(String utenteEmail);

    List<Utente> getUtentiTecnici();

    List<Utente> getAllUtenti();

    Utente updateUtente(Utente utente);

    void deleteUtente(int utenteId);
}
