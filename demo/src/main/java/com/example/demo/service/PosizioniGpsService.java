package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.PosizioniGps;

public interface PosizioniGpsService {
    
    PosizioniGps createPosizione(PosizioniGps posizione);

    PosizioniGps getPosizioneById(int posizioneId);

    List<PosizioniGps> getAllPosizioniOrderByDesc();

    List<Optional<PosizioniGps>> getPosizioneByCliente(Cliente cliente);

    void deletePosizione(int posizioneId);
}
