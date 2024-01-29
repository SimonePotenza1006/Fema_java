package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Ruolo;

public interface RuoloService {
    
    Ruolo createRuolo(Ruolo ruolo);

	Ruolo getRuoloById(int ruoloId);

    List<Ruolo> getAllRuoli();

    Ruolo updateRuolo(Ruolo ruolo);

    void deleteRuolo(int ruoloId);
}
