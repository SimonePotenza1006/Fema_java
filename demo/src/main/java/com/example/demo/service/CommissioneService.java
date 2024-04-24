package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Commissione;

public interface CommissioneService {
    
    Commissione createCommissione(Commissione commissione);

    Commissione getCommissioneById(int commissioneId);

    List<Commissione> getAllCommissioni();

    List<Optional<Commissione>> getCommissioneByUtente(Utente utente);

    List<Commissione> getAllCommissioniOrderByDesc();

    Commissione updateCommissione(Commissione commissione);

    void deleteCommissione(int commissioneId);
}
