package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demo.entity.Utente;
import com.example.demo.entity.UtenteSivis;

@Repository
public interface UtenteSivisRepository extends JpaRepository<UtenteSivis, Integer>{
    UtenteSivis findByEmail(String email);
}
