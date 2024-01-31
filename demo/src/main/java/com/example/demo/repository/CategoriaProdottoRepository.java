package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CategoriaProdotto;

@Repository
public interface CategoriaProdottoRepository extends JpaRepository<CategoriaProdotto, Integer>{
    Optional<CategoriaProdotto> findById(int id);
}
