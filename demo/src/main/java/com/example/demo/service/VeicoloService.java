package com.example.demo.service;

import com.example.demo.entity.Veicolo;

import java.util.List;

public interface VeicoloService {
    
    Veicolo createVeicolo(Veicolo veicolo);

    Veicolo getVeicoloById(int veicoloId);

    List<Veicolo> getAllVeicoli();

    Veicolo updateVeicolo(Veicolo veicolo);

    void deleteVeicolo(int veicoloId);

}
