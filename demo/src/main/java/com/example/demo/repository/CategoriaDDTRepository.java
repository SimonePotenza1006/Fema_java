package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CategoriaDDT;

@Repository
public interface CategoriaDDTRepository extends JpaRepository<CategoriaDDT, Integer>{
    Optional<CategoriaDDT> findById(int id);
}
