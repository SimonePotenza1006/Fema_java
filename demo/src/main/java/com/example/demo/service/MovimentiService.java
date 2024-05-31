package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.Movimenti;
import com.example.demo.repository.MovimentiRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovimentiService {
    
    @Autowired
    private MovimentiRepository movimentiRepository;

    // Metodo per recuperare tutti i movimenti
    public List<Movimenti> getAllMovimenti() {
        return movimentiRepository.findAll();
    }

    // Metodo per recuperare un movimento per ID
    public Optional<Movimenti> getMovimentiById(int id) {
        return movimentiRepository.findById(id);
    }

    public List<Movimenti> getAllMovimentiOrderByDesc(){
        List<Movimenti> optionalMovimenti = movimentiRepository.findAllByOrderByIdDesc();
        return optionalMovimenti;
    }

    public List<Optional<Movimenti>> getMovimentiByIntervento(Intervento intervento){
        List<Optional<Movimenti>> movimenti = movimentiRepository.findByIntervento(intervento);
        return movimenti;
    }

    // Metodo per salvare un movimento
    public Movimenti saveMovimenti(Movimenti movimento) {
        return movimentiRepository.save(movimento);
    }

    // Metodo per eliminare un movimento per ID
    public void deleteMovimentiById(int id) {
        movimentiRepository.deleteById(id);
    }
}
