package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Immagine;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.Veicolo;


@Transactional
@Repository
public interface ImmagineRepository extends JpaRepository<Immagine, Integer>{
    
    Optional<Immagine> findByName (String name);
    List<Immagine> findAll();
    Optional<Immagine> findByIntervento(Intervento intervento);
    List<Optional<Immagine>> findBySopralluogo(Sopralluogo sopralluogo);
    List<Optional<Immagine>> findByMerceInRiparazione(MerceInRiparazione merce);
    List<Optional<Immagine>> findByVeicolo(Veicolo veicolo);
}
;