package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Destinazione;
import com.example.demo.entity.Cliente;

@Repository
public interface DestinazioneRepository extends JpaRepository<Destinazione, Integer> {
    Optional<Destinazione> findById(int id);
    List<Optional<Destinazione>> findDestinazioneByCliente(Cliente cliente);
}
