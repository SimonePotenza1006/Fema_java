package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Azienda;


@Repository
public interface AziendaRepository extends JpaRepository<Azienda, Integer>{
    Optional<Azienda> findById(int id);
}
