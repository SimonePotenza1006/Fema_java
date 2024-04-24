package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.TipologiaIntervento;

public interface SopralluogoService {

    Sopralluogo createSopralluogo(Sopralluogo sopralluogo);

    Sopralluogo getSopralluogoById(int sopralluogoId);

    List<Sopralluogo> getAllSopralluoghi();

    List<Optional<Sopralluogo>> getSopralluogoByUtente(Utente utente);

    List<Optional<Sopralluogo>> getSopralluogoByCliente(Cliente cliente);

    List<Optional<Sopralluogo>> getSopralluogoByTipologia(TipologiaIntervento tipologia);

    List<Sopralluogo> getAllSopralluoghiOrderByDesc();

    Sopralluogo updateSopralluogo(Sopralluogo sopralluogo);

    void deleteSopralluogo(int sopralluogoId);
    
}
