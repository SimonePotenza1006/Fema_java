package com.example.demo.repository;
import com.example.demo.entity.Agente;
import com.example.demo.entity.Azienda;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Preventivo;
import com.example.demo.entity.Utente;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreventivoRepository extends JpaRepository<Preventivo, Integer> {
    List<Preventivo> findAllByOrderByIdDesc();
    List<Optional<Preventivo>> findAllByOrderByAgente();
    List<Optional<Preventivo>> findByCliente(Cliente cliente);
    List<Optional<Preventivo>> findByUtente(Utente utente);
    List<Optional<Preventivo>> findByAgente(Agente agente);
    List<Optional<Preventivo>>findByAzienda(Azienda azienda);
}
