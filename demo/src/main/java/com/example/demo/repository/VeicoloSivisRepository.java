package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.VeicoloSivis;

@Repository
public interface VeicoloSivisRepository extends JpaRepository<VeicoloSivis, Integer>{
    Optional<VeicoloSivis> findById(int id);
}
