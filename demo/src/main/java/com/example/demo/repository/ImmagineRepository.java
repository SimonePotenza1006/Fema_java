package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Cartella;
import com.example.demo.entity.CredenzialiCliente;
import com.example.demo.entity.Immagine;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.Movimenti;
import com.example.demo.entity.RestituzioneMerce;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.SpesaVeicolo;
import com.example.demo.entity.Task;
import com.example.demo.entity.Veicolo;


@Transactional
@Repository
public interface ImmagineRepository extends JpaRepository<Immagine, Integer>{
    
    Optional<Immagine> findByName (String name);
    List<Immagine> findAll();
    List<Immagine> findByIntervento(Intervento intervento);
    List<Immagine> findBySopralluogo(Sopralluogo sopralluogo);
    List<Immagine> findByMerceInRiparazione(MerceInRiparazione merce);
    List<Immagine> findByCartella(Cartella cartella);
    //List<Immagine> findByAzienda(Azienda azienda);
    List<Immagine> findByVeicolo(Veicolo veicolo);
    List<Immagine> findBySpesaVeicolo(SpesaVeicolo spesa);
    List<Immagine> findByMovimento(Movimenti movimento);
    List<Immagine> findByRestituzione(RestituzioneMerce restituzione);
    List<Immagine> findByCredenziali(CredenzialiCliente credenziali);
    List<Immagine> findByTask(Task task);
}
