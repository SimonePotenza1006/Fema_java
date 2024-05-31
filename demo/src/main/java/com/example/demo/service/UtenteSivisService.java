package com.example.demo.service;
import com.example.demo.entity.UtenteSivis;
import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.Utente;

import java.util.List;
import java.util.Set;

public interface UtenteSivisService {
    
    ApiResponse login(UtenteSivis utente);

    UtenteSivis ulogin(UtenteSivis utente);

    UtenteSivis createUtente(UtenteSivis utente);

    UtenteSivis getUtenteById(int utenteId);

    UtenteSivis getUtenteByEmail(String utenteEmail);

    UtenteSivis updateUtente(UtenteSivis utente);

    void deleteUtente(int utenteId);
}
