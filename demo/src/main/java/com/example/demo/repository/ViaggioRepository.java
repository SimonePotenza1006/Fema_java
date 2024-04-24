package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Utente;
import com.example.demo.entity.Viaggio;


@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Integer> {
    Optional<Viaggio> findById(int id);
    //List<Optional<Viaggio>> findByUtenti(Utente utente);
    List<Viaggio> findAllByOrderByIdDesc();
}
