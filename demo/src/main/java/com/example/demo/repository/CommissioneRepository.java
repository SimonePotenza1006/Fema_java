package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

import com.example.demo.entity.Utente;
import com.example.demo.entity.Commissione;



@Repository
public interface CommissioneRepository extends JpaRepository<Commissione, Integer>{
    
    List<Commissione> findAllByOrderByIdDesc();
    Optional<Commissione> findById(int id);
    List<Optional<Commissione>> findByUtente(Utente utente);
    
}
