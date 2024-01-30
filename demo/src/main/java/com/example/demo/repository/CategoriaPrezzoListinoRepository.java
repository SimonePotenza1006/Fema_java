package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CategoriaPrezzoListino;

@Repository
public interface CategoriaPrezzoListinoRepository extends JpaRepository<CategoriaPrezzoListino, Integer>{
    Optional<CategoriaPrezzoListino> findById(int id);
}
