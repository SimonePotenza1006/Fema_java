package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoriaDDT;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Ddt;
import com.example.demo.entity.Destinazione;
import com.example.demo.entity.Utente;
import com.example.demo.repository.DdtRepository;
import com.example.demo.service.DdtService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DdtServiceImpl implements DdtService{
    
    private DdtRepository ddtRepository;

    @Override
    public Ddt createDdt(Ddt ddt){
        return ddtRepository.save(ddt);
    }

    @Override
    public Ddt getDdtById(int ddtId){
        Optional<Ddt> optionalDdt = ddtRepository.findById(ddtId);
        return optionalDdt.get();
    }

    @Override
    public List<Ddt> getAllDdt(){
        return ddtRepository.findAll();
    }

    @Override
    public List<Optional<Ddt>> getDdtByCliente(Cliente cliente) {
        List<Optional<Ddt>> optionalDdt = ddtRepository.findByCliente(cliente);
        return optionalDdt;
    }

    @Override
    public List<Optional<Ddt>> getDdtByCategoriaDdt(CategoriaDDT categoria){
        List<Optional<Ddt>> optionalDdt = ddtRepository.findByCategoriaDdt(categoria);
        return optionalDdt;
    }

    @Override
    public List<Optional<Ddt>> getDdtByDestinazione(Destinazione destinazione){
        List<Optional<Ddt>> optionalDdt = ddtRepository.findByDestinazione(destinazione);
        return optionalDdt;
    }

    @Override
    public List<Optional<Ddt>> getDdtByUtente(Utente utente){
        List<Optional<Ddt>> optionalDdt = ddtRepository.findByUtente(utente);
        return optionalDdt;
    }

    @Override
    public Ddt updateDdt(Ddt ddt){
        return ddtRepository.save(ddt);
    }

    @Override
    public void deleteDdt(int ddtId){
        ddtRepository.deleteById(ddtId);
    }
}
