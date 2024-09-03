package com.example.demo.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TipologiaMovimento;

@Repository
public interface TipologiaMovimentoRepository extends JpaRepository<TipologiaMovimento, Integer>{
    List<TipologiaMovimento> findAll();
}
