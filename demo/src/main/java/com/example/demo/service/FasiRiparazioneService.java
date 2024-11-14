package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.FasiRiparazione;
import com.example.demo.entity.MerceInRiparazione;


public interface FasiRiparazioneService {
    
    FasiRiparazione createFase(FasiRiparazione fase);

    List<FasiRiparazione> getFasiByMerce(MerceInRiparazione merce);

    void deleteFase(int faseId);

}
