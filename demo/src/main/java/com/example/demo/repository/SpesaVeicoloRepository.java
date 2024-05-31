package com.example.demo.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SpesaVeicolo;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Veicolo;


@Repository
public interface SpesaVeicoloRepository extends JpaRepository<SpesaVeicolo, Integer>{
    List<SpesaVeicolo> findAllByOrderByIdSpesaVeicoloDesc();
    Optional<SpesaVeicolo> findByIdSpesaVeicolo(int id_spesa_veicolo);
    List<Optional<SpesaVeicolo>> findByUtente(Utente utente);
    List<Optional<SpesaVeicolo>> findByVeicolo(Veicolo veicolo);
}
