package com.example.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.RelazioneClientiProdotti;

@Repository
public interface RelazioneClientiProdottiRepository extends JpaRepository<RelazioneClientiProdotti, Integer>{
    RelazioneClientiProdotti findById(int id);
    List<RelazioneClientiProdotti> findByCliente(Cliente cliente);
    List<RelazioneClientiProdotti> findByProdotto(Prodotto prodotto);
}
