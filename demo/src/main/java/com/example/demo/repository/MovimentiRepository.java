package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.Movimenti;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovimentiRepository extends JpaRepository<Movimenti, Integer>{
    Optional<Movimenti> findById(int id);
    List<Optional<Movimenti>> findByIntervento(Intervento intervento);
    List<Movimenti> findAllByOrderByIdDesc();
}
