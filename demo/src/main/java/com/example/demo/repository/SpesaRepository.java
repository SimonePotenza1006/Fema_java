package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Spesa;
import com.example.demo.entity.Viaggio;


@Repository
public interface SpesaRepository extends JpaRepository<Spesa, Integer> {
    Optional<Spesa> findById(int id);
    List<Optional<Spesa>> findByViaggioOrderByIdDesc(Viaggio viaggio);
}
