package com.example.demo.service;

import com.example.demo.entity.Azienda;
import java.util.List;

public interface AziendaService {
    
    Azienda createAzienda(Azienda azienda);
    
    Azienda getAziendaById (int aziendaId);

    List<Azienda> getAllAziende();

    Azienda updateAzienda(Azienda azienda);

    void deleteAzienda(int aziendaId);
}
