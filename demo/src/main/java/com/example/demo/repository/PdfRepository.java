package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Pdf;
import com.example.demo.entity.Utente;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PdfRepository extends JpaRepository<Pdf, Integer>{
    Optional<Pdf> findByName(String name);
    List<Pdf> findAll();
    List<Pdf> findByUtente(Utente utente);
    List<Pdf> findByCliente(Cliente cliente);
    List<Pdf> findByAzienda(Azienda optionalAzienda);
    List<Pdf> findByIntervento(Intervento intervento);
}
