package com.example.demo.service;

import com.example.demo.entity.Agente;
import java.util.List;

public interface AgenteService {
    
    Agente createAgente(Agente agente);

    Agente getAgenteById(int agenteId);

    List<Agente> getAllAgenti();

    Agente updateAgente(Agente agente);

    void deleteAgente(int agenteId);
}
