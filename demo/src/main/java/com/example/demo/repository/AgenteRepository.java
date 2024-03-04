package com.example.demo.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Agente;

public interface AgenteRepository extends JpaRepository<Agente, Integer> {
    Optional<Agente> findById(int id);
}
