package com.example.demo.service;
import com.example.demo.entity.Veicolo;
import com.example.demo.entity.VeicoloSivis;

import java.util.List;


public interface VeicoloSivisService {
    
    VeicoloSivis createVeicolo(VeicoloSivis veicolo);

    VeicoloSivis getVeicoloById(int veicoloId);

    List<VeicoloSivis> getAllVeicoli();

    VeicoloSivis updateVeicolo(VeicoloSivis veicolo);

    void deleteVeicolo(int veicoloId);
}
