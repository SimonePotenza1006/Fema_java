package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.UtenteSivis;
import com.example.demo.entity.VeicoloSivis;
import com.example.demo.entity.SpesaVeicolo;
import com.example.demo.entity.SpesaVeicoloSivis;

public interface SpesaVeicoloSivisService {
    
    SpesaVeicoloSivis createSpesa(SpesaVeicoloSivis spesaVeicolo);

    SpesaVeicoloSivis getSpesaById(int id);

    List<SpesaVeicoloSivis> getAllSpese();

    SpesaVeicoloSivis updateSpesa(SpesaVeicoloSivis spesaVeicolo);
    
    void deleteSpesa(int spesaId);
}
