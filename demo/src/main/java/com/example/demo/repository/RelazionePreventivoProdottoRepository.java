package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Preventivo;
import com.example.demo.entity.RelazionePreventivoProdotto;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RelazionePreventivoProdottoRepository extends JpaRepository<RelazionePreventivoProdotto, Integer>{
    RelazionePreventivoProdotto findById(int id);
    List<Optional<RelazionePreventivoProdotto>> findByPreventivo(Preventivo preventivo);
    List<Optional<RelazionePreventivoProdotto>> findByProdotto(Prodotto prodotto);
}
