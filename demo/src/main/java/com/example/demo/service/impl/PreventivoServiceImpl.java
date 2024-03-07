package com.example.demo.service.impl;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Agente;
import com.example.demo.entity.Azienda;
import com.example.demo.entity.Preventivo;
import com.example.demo.repository.PreventivoRepository;
import com.example.demo.service.PreventivoService;


@Service
@AllArgsConstructor
public class PreventivoServiceImpl implements PreventivoService{
    
    @Autowired
    private PreventivoRepository preventivoRepository;

    @Override
    public Preventivo createPreventivo(Preventivo preventivo) {
        return preventivoRepository.save(preventivo);
    }

    @Override
    public List<Preventivo> getAllPreventiviOrderByDesc(){
        List<Preventivo> optionalPreventivi = preventivoRepository.findAllByOrderByIdDesc();
        return optionalPreventivi;
    }

    @Override
    public Preventivo getPreventivoById(int preventivoId) {
        Optional<Preventivo> optionalPreventivo = preventivoRepository.findById(preventivoId);
        return optionalPreventivo.get();
    }

    @Override
    public List<Preventivo> getAllPreventivi(){
        return preventivoRepository.findAll();
    }

    @Override 
    public List<Optional<Preventivo>> getPreventivoByUtente(Utente utente){
        List<Optional<Preventivo>> optionalPreventivo = preventivoRepository.findByUtente(utente);
        return optionalPreventivo;
    }

    @Override 
    public List<Optional<Preventivo>> getPreventivoByAgente(Agente agente){
        List<Optional<Preventivo>> optionalPreventivo = preventivoRepository.findByAgente(agente);
        return optionalPreventivo;
    }

    @Override 
    public List<Optional<Preventivo>> getPreventivoByAzienda(Azienda azienda){
        List<Optional<Preventivo>> optionalPreventivo = preventivoRepository.findByAzienda(azienda);
        return optionalPreventivo;
    }

    @Override
    public Preventivo updatePreventivo(Preventivo preventivo){
        return preventivoRepository.save(preventivo);
    }

    @Override 
    public void deletePreventivo(int preventivoId){
        preventivoRepository.deleteById(preventivoId);
    }
}
