package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Commissione;
import com.example.demo.entity.Intervento;

public interface CommissioneService {
    
    Commissione createCommissione(Commissione commissione);

    Commissione getCommissioneById(int commissioneId);

    List<Commissione> getAllCommissioni();

    List<Optional<Commissione>> getCommissioneByUtente(Utente utente);

    List<Optional<Commissione>> getCommissioneByIntervento(Intervento intervento);

    List<Commissione> getAllCommissioniOrderByDesc();

    Commissione updateCommissione(Commissione commissione);

    void deleteCommissione(int commissioneId);
}
