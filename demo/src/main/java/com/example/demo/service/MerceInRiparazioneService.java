package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Utente;
import com.example.demo.entity.MerceInRiparazione;


public interface MerceInRiparazioneService {
    
    MerceInRiparazione createMerce(MerceInRiparazione merce);

    MerceInRiparazione getMerceById(int merceId);

    List<MerceInRiparazione> getAllMerce();

    List<MerceInRiparazione> getAllMerciOrderByIdDesc();

    List<Optional<MerceInRiparazione>> getMerciByUtente(Utente utente);

    void deleteMerce(int merceId);
}
