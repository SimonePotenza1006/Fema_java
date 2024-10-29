package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.FasiRiparazione;

@Repository
public interface FasiRiparazioneRepository extends JpaRepository<FasiRiparazione, Integer>{
    List<FasiRiparazione> findByMerce(MerceInRiparazione merce);
}
