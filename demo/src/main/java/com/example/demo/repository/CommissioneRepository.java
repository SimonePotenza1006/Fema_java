package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

import com.example.demo.entity.Utente;
import com.example.demo.entity.Commissione;
import com.example.demo.entity.Intervento;



@Repository
public interface CommissioneRepository extends JpaRepository<Commissione, Integer>{
    
    List<Commissione> findAllByAttivoTrueOrderByIdDesc();
    Optional<Commissione> findById(int id);
    List<Optional<Commissione>> findByUtenteAndAttivoTrue(Utente utente);
    List<Optional<Commissione>> findByIntervento(Intervento intervento);
    
}
