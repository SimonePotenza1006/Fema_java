package com.example.demo.repository;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.GruppoInterventi;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface GruppoInterventiRepository extends JpaRepository<GruppoInterventi, Integer>{
    Optional<GruppoInterventi> findById(int id);
    List<GruppoInterventi> findAllByOrderByIdDesc();
    List<Optional<GruppoInterventi>> findByConcluso(boolean concluso);
    List<Optional<GruppoInterventi>> findByCliente(Cliente cliente);
}
