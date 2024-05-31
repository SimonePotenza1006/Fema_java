package com.example.demo.repository;
import com.example.demo.entity.Cliente;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.PosizioniGps;

@Repository
public interface PosizioniGpsRepository extends JpaRepository<PosizioniGps, Integer>{
    List<PosizioniGps> findAllByOrderByIdDesc();
    List<Optional<PosizioniGps>> findByCliente(Cliente cliente);
}
