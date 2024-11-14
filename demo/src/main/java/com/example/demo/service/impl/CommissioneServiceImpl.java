package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import com.example.demo.service.CommissioneService;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Utente;
import com.example.demo.entity.Commissione;
import com.example.demo.entity.Intervento;
import com.example.demo.repository.CommissioneRepository;

@Service
@AllArgsConstructor
public class CommissioneServiceImpl implements CommissioneService{
    
    @Autowired
    private CommissioneRepository commissioneRepository;

    @Override
    public Commissione createCommissione(Commissione commissione){
        return commissioneRepository.save(commissione);
    }

    @Override
    public Commissione getCommissioneById(int commissioneId){
        Optional<Commissione> optionalCommissione = commissioneRepository.findById(commissioneId);
        return optionalCommissione.get();
    }

    @Override
    public List<Commissione> getAllCommissioni() {
        return commissioneRepository.findAll();
    }

    @Override
    public List<Commissione> getAllCommissioniOrderByDesc() {
        List<Commissione> optionalCommissione = commissioneRepository.findAllByAttivoTrueOrderByIdDesc();
        return optionalCommissione;
    }

    @Override
    public List<Optional<Commissione>> getCommissioneByUtente(Utente utente){
        List<Optional<Commissione>> optionalCommissione = commissioneRepository.findByUtenteAndAttivoTrue(utente);
        return optionalCommissione;
    }

    @Override 
    public List<Optional<Commissione>> getCommissioneByIntervento(Intervento intervento){
        List<Optional<Commissione>> optionalCommissione = commissioneRepository.findByIntervento(intervento);
        return optionalCommissione;
    }

    @Override
    public Commissione updateCommissione(Commissione commissione){
        return commissioneRepository.save(commissione);
    }

    @Override
    public void deleteCommissione(int commissioneId){
        commissioneRepository.deleteById(commissioneId);
    }
}
