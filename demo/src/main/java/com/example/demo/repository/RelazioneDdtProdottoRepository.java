package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ddt;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.RelazioneDdtProdotto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RelazioneDdtProdottoRepository extends JpaRepository<RelazioneDdtProdotto, Integer>{
    Optional<RelazioneDdtProdotto> findById(int id);
    List<Optional<RelazioneDdtProdotto>> findByDdt (Ddt ddt);
    List<Optional<RelazioneDdtProdotto>> findByProdotto(Prodotto prodotto);
}
