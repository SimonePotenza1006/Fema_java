package com.example.demo.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.SpesaVeicoloSivis;


@Repository
public interface SpesaVeicoloSivisRepository extends JpaRepository<SpesaVeicoloSivis, Integer>{
    List<SpesaVeicoloSivis> findAllByOrderByIdDesc();
    Optional<SpesaVeicoloSivis> findById(int id);
}
