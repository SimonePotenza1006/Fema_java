package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.Utente;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Destinazione;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.NotaTecnico;
import com.example.demo.repository.NotaTecnicoRepository;
import com.example.demo.service.NotaTecnicoService;


@Service
@AllArgsConstructor
public class NotaTecnicoServiceImpl implements NotaTecnicoService{
    
    @Autowired
    private NotaTecnicoRepository notaRepository;

    @Override
    public NotaTecnico createNota(NotaTecnico nota){
        return notaRepository.save(nota);
    }

    @Override 
    public NotaTecnico getNotaById(int notaId){
        Optional<NotaTecnico> optionalNota = notaRepository.findById(notaId);
        return optionalNota.get();
    }

    @Override 
    public List<NotaTecnico> getAllNoteOrderByDesc(){
        List<NotaTecnico> optionalNote = notaRepository.findAllByOrderByIdDesc();
        return optionalNote;
    }

    @Override 
    public List<Optional<NotaTecnico>> getNotaByIntervento(Intervento intervento){
        List<Optional<NotaTecnico>> optionalNota = notaRepository.findByIntervento(intervento);
        return optionalNota; 
    }

    @Override 
    public List<Optional<NotaTecnico>> getNotaByCliente(Cliente cliente){
        List<Optional<NotaTecnico>> optionalNota = notaRepository.findByCliente(cliente);
        return optionalNota;
    }

    @Override 
    public List<Optional<NotaTecnico>> getNotaByDestinazione(Destinazione destinazione){
        List<Optional<NotaTecnico>> optionalNota = notaRepository.findByDestinazione(destinazione);
        return optionalNota;
    }

    @Override 
    public List<Optional<NotaTecnico>> getNotaBySopralluogo(Sopralluogo sopralluogo){
        List<Optional<NotaTecnico>> optionalNota = notaRepository.findBySopralluogo(sopralluogo);
        return optionalNota;
    }

    @Override 
    public List<Optional<NotaTecnico>> getNotaByMerce(MerceInRiparazione merce){
        List<Optional<NotaTecnico>> optionalNota = notaRepository.findByMerce(merce);
        return optionalNota;
    }

    @Override 
    public List<Optional<NotaTecnico>> getNotaByUtente(Utente utente){
        List<Optional<NotaTecnico>> optionalNota = notaRepository.findByUtente(utente);
        return optionalNota;
    }

    @Override 
    public NotaTecnico updateNota(NotaTecnico nota){
        return notaRepository.save(nota);
    }

    @Override 
    public void deleteNota(int notaId){
        notaRepository.deleteById(notaId);
    }
}
