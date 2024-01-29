package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Attrezzatura;

@Repository
public interface AttrezzaturaRepository extends JpaRepository<Attrezzatura, Integer>{
    Optional<Attrezzatura> findById(int id);
}
