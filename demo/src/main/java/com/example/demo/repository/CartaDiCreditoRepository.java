package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CartaDiCredito;


@Repository
public interface CartaDiCreditoRepository extends JpaRepository<CartaDiCredito, Integer>{
    Optional<CartaDiCredito> findById(int id);
}
