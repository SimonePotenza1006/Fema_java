package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Fornitore;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.CategoriaProdotto;


@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer>{
    Optional<Prodotto> findById(int id);
    List<Optional<Prodotto>> findByFornitore(Fornitore fornitore);
    List<Optional<Prodotto>> findByCategoriaProdotto(CategoriaProdotto categoriaProdotto);
}
