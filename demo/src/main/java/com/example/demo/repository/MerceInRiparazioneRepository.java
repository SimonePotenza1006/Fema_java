package com.example.demo.repository;
import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Utente;
import com.example.demo.entity.MerceInRiparazione;

@Repository
public interface MerceInRiparazioneRepository extends JpaRepository<MerceInRiparazione, Integer>{
    List<MerceInRiparazione> findAllByOrderByIdDesc();
    List<Optional<MerceInRiparazione>> findByUtente(Utente utente);
}
